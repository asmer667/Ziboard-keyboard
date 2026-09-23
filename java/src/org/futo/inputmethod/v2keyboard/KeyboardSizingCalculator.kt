package org.futo.inputmethod.v2keyboard

import android.content.Context
import android.graphics.Rect
import android.os.Build
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.width
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.window.layout.FoldingFeature
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encodeToString
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.json.Json
import org.futo.inputmethod.latin.FoldStateProvider
import org.futo.inputmethod.latin.LatinIME
import org.futo.inputmethod.latin.settings.SettingsValues
import org.futo.inputmethod.latin.uix.OldStyleActionsBar
import org.futo.inputmethod.latin.uix.SettingsKey
import org.futo.inputmethod.latin.uix.UixManager
import org.futo.inputmethod.latin.uix.getSetting
import org.futo.inputmethod.latin.uix.getSettingBlocking
import org.futo.inputmethod.latin.uix.setSettingBlocking
import org.futo.inputmethod.latin.utils.ResourceUtils
import kotlin.math.roundToInt

val OldKeyboardHeightMultiplierSetting = SettingsKey(floatPreferencesKey("keyboardHeightMultiplier"), 1.0f)
val OldKeyboardBottomOffsetSetting = SettingsKey(floatPreferencesKey("keyboardOffset"), 0.0f)

interface KeyboardSizeStateProvider {
    val currentSizeState: KeyboardSizeSettingKind
}

sealed class ComputedKeyboardSize(
    val width: Int,
    val height: Int,
    val padding: Rect,
    val singleRowHeight: Int = height / 4
) {
    override fun toString(): String {
        return "${this.javaClass.simpleName}(width=$width height=$height padding=$padding singleRowHeight=$singleRowHeight)"
    }
}

class RegularKeyboardSize(
    width: Int, height: Int, padding: Rect, singleRowHeight: Int = height / 4
) : ComputedKeyboardSize(width, height, padding, singleRowHeight)

class SplitKeyboardSize(
    width: Int, height: Int, padding: Rect, singleRowHeight: Int = height / 4,
    val splitLayoutWidth: Int
) : ComputedKeyboardSize(width, height, padding, singleRowHeight)

enum class OneHandedDirection {
    Left,
    Right
}

val OneHandedDirection.opposite: OneHandedDirection
    get() = when(this) {
        OneHandedDirection.Left -> OneHandedDirection.Right
        OneHandedDirection.Right -> OneHandedDirection.Left
    }

class OneHandedKeyboardSize(
    width: Int, height: Int, padding: Rect, singleRowHeight: Int = height / 4,
    val layoutWidth: Int, val direction: OneHandedDirection
) : ComputedKeyboardSize(width, height, padding, singleRowHeight)

class FloatingKeyboardSize(
    width: Int, height: Int, padding: Rect, singleRowHeight: Int = height / 4,
    val bottomOrigin: Pair<Int, Int>
): ComputedKeyboardSize(width, height, padding, singleRowHeight)

val ComputedKeyboardSize.totalKeyboardWidth: Int
    get() = when(this) {
        is FloatingKeyboardSize -> width - padding.left - padding.right
        is OneHandedKeyboardSize -> layoutWidth
        is RegularKeyboardSize -> width - padding.left - padding.right
        is SplitKeyboardSize -> width - padding.left - padding.right
    }

fun ComputedKeyboardSize.dimensionsSameAs(other: ComputedKeyboardSize?): Boolean {
    if(other == null) return false

    return when(this) {
        is FloatingKeyboardSize -> other is FloatingKeyboardSize && other.height == height && other.width == width && other.padding == padding && other.singleRowHeight == singleRowHeight && other.bottomOrigin == bottomOrigin
        is OneHandedKeyboardSize -> other is OneHandedKeyboardSize && other.layoutWidth == layoutWidth && other.width == width && other.padding == padding && other.direction == direction && other.singleRowHeight == singleRowHeight
        is RegularKeyboardSize -> other is RegularKeyboardSize && other.width == width && other.padding == padding && other.height == height && other.singleRowHeight == singleRowHeight
        is SplitKeyboardSize -> other is SplitKeyboardSize && other.height == height && other.padding == padding && other.singleRowHeight == singleRowHeight && other.splitLayoutWidth == splitLayoutWidth && other.width == width
    }
}

enum class KeyboardMode {
    Regular,
    Split,
    OneHanded,
    Floating
}

object DpRectSerializer : KSerializer<DpRect> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("DpRect") {
        element<Float>("left")
        element<Float>("top")
        element<Float>("right")
        element<Float>("bottom")
    }

    override fun serialize(encoder: Encoder, value: DpRect) {
        encoder.encodeStructure(descriptor) {
            encodeFloatElement(descriptor, 0, value.left.value)
            encodeFloatElement(descriptor, 1, value.top.value)
            encodeFloatElement(descriptor, 2, value.right.value)
            encodeFloatElement(descriptor, 3, value.bottom.value)
        }
    }

    override fun deserialize(decoder: Decoder): DpRect {
        return decoder.decodeStructure(descriptor) {
            var left = 0.0f
            var top = 0.0f
            var right = 0.0f
            var bottom = 0.0f

            while (true) {
                when (val index = decodeElementIndex(descriptor)) {
                    0 -> left = decodeFloatElement(descriptor, 0)
                    1 -> top = decodeFloatElement(descriptor, 1)
                    2 -> right = decodeFloatElement(descriptor, 2)
                    3 -> bottom = decodeFloatElement(descriptor, 3)
                    CompositeDecoder.DECODE_DONE -> break
                    else -> error("Unexpected index: $index")
                }
            }

            DpRect(left = left.dp, top = top.dp, right = right.dp, bottom = bottom.dp)
        }
    }
}

typealias SDpRect = @Serializable(with = DpRectSerializer::class) DpRect

@Serializable
data class SavedKeyboardSizingSettings(
    val currentMode: KeyboardMode,
    val heightMultiplier: Float,
    val heightAdditionDp: Float = 0.0f,
    val paddingDp: SDpRect,

    // Split
    val splitWidthFraction: Float,
    val splitPaddingDp: SDpRect,
    val splitHeightAdditionDp: Float = 0.0f,
    val prefersSplit: Boolean,

    val oneHandedRectDp: SDpRect,
    val oneHandedDirection: OneHandedDirection,
    val oneHandedHeightAdditionDp: Float = 0.0f,

    // Floating
    val floatingBottomOriginDp: Pair<Float, Float>,
    val floatingWidthDp: Float,
    val floatingHeightDp: Float,
) {
    fun toJsonString(): String =
        Json.encodeToString(this)

    companion object {
        @JvmStatic
        fun fromJsonString(s: String): SavedKeyboardSizingSettings? =
            try {
                Json.decodeFromString(s)
            } catch (e: Exception) {
                null
            }
    }
}

private fun Float.guardNaN(fallback: Float): Float = if (this.isNaN()) fallback else this

fun getDefaultSettingForKind(kind: KeyboardSizeSettingKind, context: Context): SavedKeyboardSizingSettings {
    val oldBottomOffset = context.getSettingBlocking(OldKeyboardBottomOffsetSetting).dp

    val metrics = context.resources.displayMetrics
    val density = metrics.density.toFloat()
    val minDimDp = (minOf(metrics.widthPixels, metrics.heightPixels).toFloat() / density).dp

    val oldHeightMultiplier = context.getSettingBlocking(OldKeyboardHeightMultiplierSetting).guardNaN(1.0f) +
                metrics.heightPixels.toFloat().let { height ->
                    if(height > 0.0f) {
                        (oldBottomOffset.value * density) / height
                    } else {
                        0.0f
                    }
                }

    val extraSidePadding = when {
        minDimDp > 600.dp -> 24.dp
        else -> 0.dp
    }

    val portraitDeviceSizeHeightMultiplier = when {
        minDimDp > 600.dp -> 0.8f
        else -> 1.0f
    }

    val portraitSplitWidthFraction = when {
        minDimDp > 600.dp -> 3.0f / 5.0f
        else -> 4.0f / 5.0f
    }

    return when(kind) {
        KeyboardSizeSettingKind.Portrait -> SavedKeyboardSizingSettings(
            currentMode = KeyboardMode.Regular,
            heightMultiplier = 1.0f * oldHeightMultiplier * portraitDeviceSizeHeightMultiplier,
            paddingDp = DpRect(2.dp + extraSidePadding, 4.dp, 2.dp + extraSidePadding, 10.dp + oldBottomOffset),
            splitPaddingDp = DpRect(2.dp, 4.dp, 2.dp, 10.dp + oldBottomOffset),
            splitWidthFraction = portraitSplitWidthFraction,
            oneHandedDirection = OneHandedDirection.Right,
            oneHandedRectDp = DpRect(4.dp, 4.dp, 364.dp, 30.dp + oldBottomOffset),
            floatingBottomOriginDp = Pair(0.0f, 0.0f),
            floatingHeightDp = 240.0f,
            floatingWidthDp = 360.0f,
            prefersSplit = false
        )

        KeyboardSizeSettingKind.Landscape -> SavedKeyboardSizingSettings(
            currentMode = KeyboardMode.Split,
            heightMultiplier = 0.9f * oldHeightMultiplier,
            paddingDp = DpRect(8.dp + extraSidePadding, 2.dp, 8.dp + extraSidePadding, 2.dp),
            splitPaddingDp = DpRect(8.dp, 2.dp, 8.dp, 2.dp),
            splitWidthFraction = 3.0f / 5.0f,
            oneHandedDirection = OneHandedDirection.Right,
            oneHandedRectDp = DpRect(4.dp, 4.dp, 364.dp, 30.dp),
            floatingBottomOriginDp = Pair(0.0f, 0.0f),
            floatingHeightDp = 200.0f,
            floatingWidthDp = 320.0f,
            prefersSplit = true
        )
    }
}

enum class KeyboardSizeSettingKind {
    Portrait,
    Landscape
}
