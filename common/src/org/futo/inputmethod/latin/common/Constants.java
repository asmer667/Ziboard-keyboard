/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.futo.inputmethod.latin.common;

import org.futo.inputmethod.annotations.UsedForTesting;

import javax.annotation.Nonnull;

public final class Constants {

    public static final class Color {
        public final static int ALPHA_OPAQUE = 255;
    }

    public static final class ImeOption {
        @SuppressWarnings("dep-ann")
        public static final String NO_MICROPHONE_COMPAT = "nm";

        public static final String NO_MICROPHONE = "noMicrophoneKey";

        public static final String NO_SETTINGS_KEY = "noSettingsKey";

        @SuppressWarnings("dep-ann")
        public static final String FORCE_ASCII = "forceAscii";

        public static final String NO_FLOATING_GESTURE_PREVIEW = "noGestureFloatingPreview";

        private ImeOption() {
        }
    }

    public static final class Subtype {
        public static final String KEYBOARD_MODE = "keyboard";

        public static final class ExtraValue {
            public static final String ASCII_CAPABLE = "AsciiCapable";
            public static final String ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE = "EnabledWhenDefaultIsNotAsciiCapable";
            public static final String EMOJI_CAPABLE = "EmojiCapable";
            public static final String REQ_NETWORK_CONNECTIVITY = "requireNetworkConnectivity";
            public static final String UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME = "UntranslatableReplacementStringInSubtypeName";
            public static final String KEYBOARD_LAYOUT_SET = "KeyboardLayoutSet";
            public static final String IS_ADDITIONAL_SUBTYPE = "isAdditionalSubtype";
            public static final String COMBINING_RULES = "CombiningRules";

            private ExtraValue() {
            }
        }

        private Subtype() {
        }
    }

    public static final class TextUtils {
        public static final int CAP_MODE_OFF = 0;

        private TextUtils() {
        }
    }

    public static final int NOT_A_CODE = -1;
    public static final int NOT_A_CURSOR_POSITION = -1;
    public static final int NOT_A_COORDINATE = -1;
    public static final int SUGGESTION_STRIP_COORDINATE = -2;
    public static final int EXTERNAL_KEYBOARD_COORDINATE = -4;

    public static final int EDITOR_CONTENTS_CACHE_SIZE = 1024;
    public static final int MAX_CHARACTERS_FOR_RECAPITALIZATION = 1024 * 100;

    public static final int LONG_PRESS_MILLISECONDS = 200;
    public static final int GET_SUGGESTED_WORDS_TIMEOUT = 200;
    public static final int DELETE_ACCELERATE_AT = 20;

    public static final String WORD_SEPARATOR = " ";

    public static boolean isValidCoordinate(final int coordinate) {
        return coordinate >= 0;
    }

    public static final int CUSTOM_CODE_SHOW_INPUT_METHOD_PICKER = 1;

    public static final int CODE_ENTER = '\n';
    public static final int CODE_TAB = '\t';
    public static final int CODE_SPACE = ' ';
    public static final int CODE_PERIOD = '.';
    public static final int CODE_COMMA = ',';
    public static final int CODE_DASH = '-';
    public static final int CODE_SINGLE_QUOTE = '\'';
    public static final int CODE_DOUBLE_QUOTE = '"';
    public static final int CODE_SLASH = '/';
    public static final int CODE_BACKSLASH = '\\';
    public static final int CODE_VERTICAL_BAR = '|';
    public static final int CODE_COMMERCIAL_AT = '@';
    public static final int CODE_PLUS = '+';
    public static final int CODE_PERCENT = '%';
    public static final int CODE_CLOSING_PARENTHESIS = ')';
    public static final int CODE_CLOSING_SQUARE_BRACKET = ']';
    public static final int CODE_CLOSING_CURLY_BRACKET = '}';
    public static final int CODE_CLOSING_ANGLE_BRACKET = '>';
    public static final int CODE_INVERTED_QUESTION_MARK = 0xBF;
    public static final int CODE_INVERTED_EXCLAMATION_MARK = 0xA1;
    public static final int CODE_GRAVE_ACCENT = '`';
    public static final int CODE_CIRCUMFLEX_ACCENT = '^';
    public static final int CODE_TILDE = '~';

    public static final String REGEXP_PERIOD = "\\.";
    public static final String STRING_SPACE = " ";

    public static final int CODE_SHIFT = -1;
    public static final int CODE_CAPSLOCK = -2;
    public static final int CODE_SWITCH_ALPHA_SYMBOL = -3;
    public static final int CODE_OUTPUT_TEXT = -4;
    public static final int CODE_DELETE = -5;
    public static final int CODE_SETTINGS = -6;
    public static final int CODE_SHORTCUT = -7;
    public static final int CODE_ACTION_NEXT = -8;
    public static final int CODE_ACTION_PREVIOUS = -9;
    public static final int CODE_LANGUAGE_SWITCH = -10;
    public static final int CODE_EMOJI = -11;
    public static final int CODE_SHIFT_ENTER = -12;
    public static final int CODE_SYMBOL_SHIFT = -13;
    public static final int CODE_ALPHA_FROM_EMOJI = -14;
    public static final int CODE_TO_NUMBER_LAYOUT = -15;
    public static final int CODE_TO_ALT_0_LAYOUT = -16;
    public static final int CODE_TO_ALT_1_LAYOUT = -17;
    public static final int CODE_TO_ALT_2_LAYOUT = -18;
    public static final int CODE_TO_ALPHA_0_LAYOUT = -19;
    public static final int CODE_TO_ALPHA_1_LAYOUT = -20;
    public static final int CODE_TO_ALPHA_2_LAYOUT = -21;
    public static final int CODE_TO_ALPHA_3_LAYOUT = -22;
    public static final int CODE_OUTPUT_TEXT_WITH_SPACES = -23;
    public static final int CODE_UNSPECIFIED = -24;

    // ===  الأزرار الجديدة (التحرير والحافظة)  ===
    public static final int CODE_MOVE_END = -30;
    public static final int CODE_ARROW_LEFT = -31;
    public static final int CODE_SELECT_ALL = -32;
    public static final int CODE_COPY = -33;
    public static final int CODE_PASTE = -34;
    public static final int CODE_ARROW_RIGHT = -35;
    public static final int CODE_MOVE_HOME = -36;
    // ============================================

    public static final int CODE_ACTION_0 = -1050;
    public static final int CODE_ACTION_MAX = CODE_ACTION_0 + 100;

    public static final int CODE_ALT_ACTION_0 = -2050;
    public static final int CODE_ALT_ACTION_MAX = CODE_ALT_ACTION_0 + 100;

    public static boolean isLetterCode(final int code) {
        return code >= CODE_SPACE;
    }

    @Nonnull
    public static String printableCode(final int code) {
        switch (code) {
        case CODE_SHIFT: return "shift";
        case CODE_CAPSLOCK: return "capslock";
        case CODE_SWITCH_ALPHA_SYMBOL: return "symbol";
        case CODE_OUTPUT_TEXT: return "text";
        case CODE_DELETE: return "delete";
        case CODE_SETTINGS: return "settings";
        case CODE_SHORTCUT: return "shortcut";
        case CODE_ACTION_NEXT: return "actionNext";
        case CODE_ACTION_PREVIOUS: return "actionPrevious";
        case CODE_LANGUAGE_SWITCH: return "languageSwitch";
        case CODE_EMOJI: return "emoji";
        case CODE_SHIFT_ENTER: return "shiftEnter";
        case CODE_ALPHA_FROM_EMOJI: return "alpha";
        case CODE_UNSPECIFIED: return "unspec";
        case CODE_TAB: return "tab";
        case CODE_ENTER: return "enter";
        case CODE_SPACE: return "space";
        // === الأزرار الجديدة ===
        case CODE_MOVE_END: return "moveEnd";
        case CODE_ARROW_LEFT: return "arrowLeft";
        case CODE_SELECT_ALL: return "selectAll";
        case CODE_COPY: return "copy";
        case CODE_PASTE: return "paste";
        case CODE_ARROW_RIGHT: return "arrowRight";
        case CODE_MOVE_HOME: return "moveHome";
        // ======================
        default:
            if (code < CODE_SPACE) return String.format("\\u%02X", code);
            if (code < 0x100) return String.format("%c", code);
            if (code < 0x10000) return String.format("\\u%04X", code);
            return String.format("\\U%05X", code);
        }
    }

    @Nonnull
    public static String printableCodes(@Nonnull final int[] codes) {
        final StringBuilder sb = new StringBuilder();
        boolean addDelimiter = false;
        for (final int code : codes) {
            if (code == NOT_A_CODE) break;
            if (addDelimiter) sb.append(", ");
            sb.append(printableCode(code));
            addDelimiter = true;
        }
        return "[" + sb + "]";
    }

    public static final int SCREEN_METRICS_SMALL_PHONE = 0;
    public static final int SCREEN_METRICS_LARGE_PHONE = 1;
    public static final int SCREEN_METRICS_LARGE_TABLET = 2;
    public static final int SCREEN_METRICS_SMALL_TABLET = 3;

    @UsedForTesting
    public static boolean isPhone(final int screenMetrics) {
        return screenMetrics == SCREEN_METRICS_SMALL_PHONE
                || screenMetrics == SCREEN_METRICS_LARGE_PHONE;
    }

    @UsedForTesting
    public static boolean isTablet(final int screenMetrics) {
        return screenMetrics == SCREEN_METRICS_SMALL_TABLET
                || screenMetrics == SCREEN_METRICS_LARGE_TABLET;
    }

    public static final int DEFAULT_GESTURE_POINTS_CAPACITY = 128;

    public static final int MAX_IME_DECODER_RESULTS = 20;
    public static final int DECODER_SCORE_SCALAR = 1000000;
    public static final int DECODER_MAX_SCORE = 1000000000;

    public static final int EVENT_BACKSPACE = 1;
    public static final int EVENT_REJECTION = 2;
    public static final int EVENT_REVERT = 3;

    public static final int VOICE_INPUT_CONTEXT_SIZE = 3;

    private Constants() {
    }
}