package org.futo.inputmethod.event.combiners.openbangla

import android.text.TextUtils
import org.futo.inputmethod.event.Combiner
import org.futo.inputmethod.event.Event
import org.futo.inputmethod.latin.common.Constants

/**
 * Combiner implementing the OpenBangla (Avro Phonetic) Unicode method for Bangla.
 * Buffers Latin-script keypresses and converts them to Bangla Unicode on the fly,
 * committing the converted word when a non-combinable key (e.g. space) is pressed.
 */
class OpenBanglaCombiner : Combiner {
    private val avro = AvroPhonetic()
    private val buffer = StringBuilder()

    // Characters that are part of Avro Phonetic input. Everything else commits the
    // current word and is passed through untouched.
    private fun isCombinable(c: Char): Boolean {
        return (c.code in 0x0041..0x007A) || // A-Z, a-z
                c == '`' ||                   // vowel killer / dead key
                c == '\''                    // apostrophe
    }

    override fun processEvent(previousEvents: ArrayList<Event>?, event: Event?): Event {
        if (event == null) return Event.createNotHandledEvent()
        if (event.eventType != Event.EVENT_TYPE_INPUT_KEYPRESS) return event

        val keypress = event.mCodePoint.toChar()

        if (!isCombinable(keypress)) {
            if (!TextUtils.isEmpty(buffer)) {
                if (event.mKeyCode == Constants.CODE_DELETE) {
                    buffer.setLength(buffer.length - 1)
                    return Event.createConsumedEvent(event)
                }
                // Commit the current phonetic word, then let the key through (e.g. space).
                return Event.createResetEvent(event)
            }
            return event
        }

        buffer.append(keypress)
        return Event.createConsumedEvent(event)
    }

    override fun getCombiningStateFeedback(): CharSequence {
        return avro.convert(buffer.toString())
    }

    override fun reset() {
        buffer.setLength(0)
    }
}
