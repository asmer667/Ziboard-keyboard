package org.futo.inputmethod.event.combiners.openbangla

// Avro Phonetic conversion engine for OpenBangla (Bangla Unicode method).
// Ported from OpenBangla Keyboard (AvroPhonetic.cpp, MPL 2.0 / GPL 3).
// Data source: avrophonetic.json (OmicronLab Avro Phonetic scheme).

import java.util.ArrayList

class AvroPhonetic {
    data class Match(val type: String, val scope: String, val value: String)
    data class Rule(val replace: String, val matches: List<Match>)
    data class Pattern(val find: String, val replace: String, val rules: List<Rule>)

    private val vowel: String = "aeiou"
    private val cons: String = "bcdfghjklmnpqrstvwxyz"
    private val num: String = "1234567890"
    private val csen: String = "oiudgjnrstyz"

    private val patterns: List<Pattern> = listOf(
        Pattern("NgkSh", "ঙ্ক্ষ", listOf()),
        Pattern("Ngkkh", "ঙ্ক্ষ", listOf()),
        Pattern("NGch", "ঞ্ছ", listOf()),
        Pattern("NGjh", "ঞ্ঝ", listOf()),
        Pattern("Nggh", "ঙ্ঘ", listOf()),
        Pattern("Ngkh", "ঙ্খ", listOf()),
        Pattern("Ngkx", "ঙ্ক্ষ", listOf()),
        Pattern("ShTh", "ষ্ঠ", listOf()),
        Pattern("Shph", "ষ্ফ", listOf()),
        Pattern("kShN", "ক্ষ্ণ", listOf()),
        Pattern("kShm", "ক্ষ্ম", listOf()),
        Pattern("kkhN", "ক্ষ্ণ", listOf()),
        Pattern("kkhm", "ক্ষ্ম", listOf()),
        Pattern("ngOI", "ঙ্গৈ", listOf()),
        Pattern("ngOU", "ঙ্গৌ", listOf()),
        Pattern("rri`", "ৃ", listOf()),
        Pattern("shch", "শ্ছ", listOf()),
        Pattern("...", "...", listOf()),
        Pattern("Gdh", "গ্ধ", listOf()),
        Pattern("Ghn", "ঘ্ন", listOf()),
        Pattern("NDh", "ণ্ঢ", listOf()),
        Pattern("NGc", "ঞ্চ", listOf()),
        Pattern("NGj", "ঞ্জ", listOf()),
        Pattern("NGr", "ঞর", listOf()),
        Pattern("NTh", "ণ্ঠ", listOf()),
        Pattern("Ngg", "ঙ্গ", listOf()),
        Pattern("Ngk", "ঙ্ক", listOf()),
        Pattern("Ngm", "ঙ্ম", listOf()),
        Pattern("Ngr", "ঙর", listOf()),
        Pattern("Ngx", "ঙ্ষ", listOf()),
        Pattern("OI`", "ৈ", listOf()),
        Pattern("OU`", "ৌ", listOf()),
        Pattern("Sch", "শ্ছ", listOf()),
        Pattern("ShN", "ষ্ণ", listOf()),
        Pattern("ShT", "ষ্ট", listOf()),
        Pattern("Shf", "ষ্ফ", listOf()),
        Pattern("Shk", "ষ্ক", listOf()),
        Pattern("Shm", "ষ্ম", listOf()),
        Pattern("Shp", "ষ্প", listOf()),
        Pattern("bdh", "ব্ধ", listOf()),
        Pattern("bhl", "ভ্ল", listOf()),
        Pattern("cNG", "চ্ঞ", listOf()),
        Pattern("cch", "চ্ছ", listOf()),
        Pattern("dbh", "দ্ভ", listOf()),
        Pattern("ddh", "দ্ধ", listOf()),
        Pattern("dgh", "দ্ঘ", listOf()),
        Pattern("dhm", "ধ্ম", listOf()),
        Pattern("dhn", "ধ্ন", listOf()),
        Pattern("ee`", "ী", listOf()),
        Pattern("gdh", "গ্ধ", listOf()),
        Pattern("ghn", "ঘ্ন", listOf()),
        Pattern("jNG", "জ্ঞ", listOf()),
        Pattern("jjh", "জ্ঝ", listOf()),
        Pattern("kSh", "ক্ষ", listOf()),
        Pattern("kkh", "ক্ষ", listOf()),
        Pattern("ksh", "কশ", listOf()),
        Pattern("kxN", "ক্ষ্ণ", listOf()),
        Pattern("kxm", "ক্ষ্ম", listOf()),
        Pattern("lbh", "ল্ভ", listOf()),
        Pattern("ldh", "ল্ধ", listOf()),
        Pattern("lgh", "লঘ", listOf()),
        Pattern("lkh", "লখ", listOf()),
        Pattern("lph", "লফ", listOf()),
        Pattern("mbh", "ম্ভ", listOf()),
        Pattern("mph", "ম্ফ", listOf()),
        Pattern("mpl", "মপ্ল", listOf()),
        Pattern("mth", "ম্থ", listOf()),
        Pattern("nTh", "ন্ঠ", listOf()),
        Pattern("nch", "ঞ্ছ", listOf()),
        Pattern("ndh", "ন্ধ", listOf()),
        Pattern("ngI", "ঙ্গী", listOf()),
        Pattern("ngO", "ঙ্গো", listOf()),
        Pattern("ngU", "ঙ্গূ", listOf()),
        Pattern("nga", "ঙ্গা", listOf()),
        Pattern("nge", "ঙ্গে", listOf()),
        Pattern("ngh", "ঙ্ঘ", listOf()),
        Pattern("ngi", "ঙ্গি", listOf()),
        Pattern("ngo", "ঙ্গ", listOf()),
        Pattern("ngr", "ংর", listOf()),
        Pattern("ngu", "ঙ্গু", listOf()),
        Pattern("njh", "ঞ্ঝ", listOf()),
        Pattern("nkh", "ঙ্খ", listOf()),
        Pattern("nsh", "নশ", listOf()),
        Pattern("nth", "ন্থ", listOf()),
        Pattern("oo`", "ু", listOf()),
        Pattern("phl", "ফ্ল", listOf()),
        Pattern("psh", "পশ", listOf()),
        Pattern("rrZ", "রর‍্য", listOf()),
        Pattern("rri", "ৃ", listOf(Rule("ঋ", listOf(Match("prefix", "!consonant", ""))), Rule("ঋ", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("rry", "রর‍্য", listOf()),
        Pattern("shc", "শ্চ", listOf()),
        Pattern("shl", "শ্ল", listOf()),
        Pattern("shm", "শ্ম", listOf()),
        Pattern("shn", "শ্ন", listOf()),
        Pattern("sht", "শ্ত", listOf()),
        Pattern("skh", "স্খ", listOf()),
        Pattern("skl", "স্ক্ল", listOf()),
        Pattern("sph", "স্ফ", listOf()),
        Pattern("spl", "স্প্ল", listOf()),
        Pattern("sth", "স্থ", listOf()),
        Pattern("t``", "ৎ", listOf()),
        Pattern("tth", "ত্থ", listOf()),
        Pattern(",,", "্‌", listOf()),
        Pattern("..", "।।", listOf()),
        Pattern(".`", ".", listOf()),
        Pattern(":`", ":", listOf()),
        Pattern("AZ", "অ্যা", listOf()),
        Pattern("A`", "া", listOf()),
        Pattern("DD", "ড্ড", listOf()),
        Pattern("Dh", "ঢ", listOf()),
        Pattern("GG", "জ্ঞ", listOf()),
        Pattern("GN", "গ্ণ", listOf()),
        Pattern("Gg", "জ্ঞ", listOf()),
        Pattern("Gh", "ঘ", listOf()),
        Pattern("Gl", "গ্ল", listOf()),
        Pattern("Gm", "গ্ম", listOf()),
        Pattern("Gn", "গ্ন", listOf()),
        Pattern("I`", "ী", listOf()),
        Pattern("ND", "ণ্ড", listOf()),
        Pattern("NG", "ঞ", listOf()),
        Pattern("NN", "ণ্ণ", listOf()),
        Pattern("NT", "ণ্ট", listOf()),
        Pattern("Ng", "ঙ", listOf()),
        Pattern("Nm", "ণ্ম", listOf()),
        Pattern("Nn", "ণ্ন", listOf()),
        Pattern("OI", "ৈ", listOf(Rule("ঐ", listOf(Match("prefix", "!consonant", ""))), Rule("ঐ", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("OU", "ৌ", listOf(Rule("ঔ", listOf(Match("prefix", "!consonant", ""))), Rule("ঔ", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("O`", "ো", listOf()),
        Pattern("Rg", "ড়্গ", listOf()),
        Pattern("Rh", "ঢ়", listOf()),
        Pattern("Sc", "শ্চ", listOf()),
        Pattern("Sc", "শ্চ", listOf()),
        Pattern("Sh", "ষ", listOf()),
        Pattern("Sl", "শ্ল", listOf()),
        Pattern("Sm", "শ্ম", listOf()),
        Pattern("Sn", "শ্ন", listOf()),
        Pattern("St", "শ্ত", listOf()),
        Pattern("TT", "ট্ট", listOf()),
        Pattern("Th", "ঠ", listOf()),
        Pattern("Tm", "ট্ম", listOf()),
        Pattern("U`", "ূ", listOf()),
        Pattern("^`", "^", listOf()),
        Pattern("aZ", "অ্যা", listOf()),
        Pattern("a`", "া", listOf()),
        Pattern("bb", "ব্ব", listOf()),
        Pattern("bd", "ব্দ", listOf()),
        Pattern("bh", "ভ", listOf()),
        Pattern("bj", "ব্জ", listOf()),
        Pattern("bl", "ব্ল", listOf()),
        Pattern("cc", "চ্চ", listOf()),
        Pattern("ch", "ছ", listOf()),
        Pattern("dd", "দ্দ", listOf()),
        Pattern("dg", "দ্গ", listOf()),
        Pattern("dh", "ধ", listOf()),
        Pattern("dm", "দ্ম", listOf()),
        Pattern("dv", "দ্ভ", listOf()),
        Pattern("e`", "ে", listOf()),
        Pattern("ee", "ী", listOf(Rule("ঈ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("ঈ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("fl", "ফ্ল", listOf()),
        Pattern("gG", "জ্ঞ", listOf()),
        Pattern("gN", "গ্ণ", listOf()),
        Pattern("gg", "জ্ঞ", listOf()),
        Pattern("gh", "ঘ", listOf()),
        Pattern("gl", "গ্ল", listOf()),
        Pattern("gm", "গ্ম", listOf()),
        Pattern("gn", "গ্ন", listOf()),
        Pattern("hN", "হ্ণ", listOf()),
        Pattern("hl", "হ্ল", listOf()),
        Pattern("hm", "হ্ম", listOf()),
        Pattern("hn", "হ্ন", listOf()),
        Pattern("i`", "ি", listOf()),
        Pattern("jh", "ঝ", listOf()),
        Pattern("jj", "জ্জ", listOf()),
        Pattern("kT", "ক্ট", listOf()),
        Pattern("kh", "খ", listOf()),
        Pattern("kk", "ক্ক", listOf()),
        Pattern("kl", "ক্ল", listOf()),
        Pattern("ks", "ক্স", listOf()),
        Pattern("kt", "ক্ত", listOf()),
        Pattern("kx", "ক্ষ", listOf()),
        Pattern("lD", "ল্ড", listOf()),
        Pattern("lT", "ল্ট", listOf()),
        Pattern("lb", "ল্ব", listOf()),
        Pattern("lg", "ল্গ", listOf()),
        Pattern("lk", "ল্ক", listOf()),
        Pattern("ll", "ল্ল", listOf()),
        Pattern("lm", "ল্ম", listOf()),
        Pattern("lp", "ল্প", listOf()),
        Pattern("lv", "ল্ভ", listOf()),
        Pattern("mb", "ম্ব", listOf()),
        Pattern("mf", "ম্ফ", listOf()),
        Pattern("ml", "ম্ল", listOf()),
        Pattern("mm", "ম্ম", listOf()),
        Pattern("mn", "ম্ন", listOf()),
        Pattern("mp", "ম্প", listOf()),
        Pattern("mv", "ম্ভ", listOf()),
        Pattern("nD", "ন্ড", listOf()),
        Pattern("nT", "ন্ট", listOf()),
        Pattern("nc", "ঞ্চ", listOf()),
        Pattern("nd", "ন্দ", listOf()),
        Pattern("ng", "ং", listOf()),
        Pattern("nj", "ঞ্জ", listOf()),
        Pattern("nk", "ঙ্ক", listOf()),
        Pattern("nm", "ন্ম", listOf()),
        Pattern("nn", "ন্ন", listOf()),
        Pattern("ns", "ন্স", listOf()),
        Pattern("nt", "ন্ত", listOf()),
        Pattern("oZ", "অ্য", listOf()),
        Pattern("o`", "", listOf()),
        Pattern("oo", "ু", listOf(Rule("উ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("উ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("pT", "প্ট", listOf()),
        Pattern("ph", "ফ", listOf()),
        Pattern("pl", "প্ল", listOf()),
        Pattern("pn", "প্ন", listOf()),
        Pattern("pp", "প্প", listOf()),
        Pattern("ps", "প্স", listOf()),
        Pattern("pt", "প্ত", listOf()),
        Pattern("rZ", "র‍্য", listOf(Rule("্র্য", listOf(Match("prefix", "consonant", ""), Match("prefix", "!exact", "r"), Match("prefix", "!exact", "y"), Match("prefix", "!exact", "w"), Match("prefix", "!exact", "x"))))),
        Pattern("rr", "রর", listOf(Rule("র্", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!vowel", ""), Match("suffix", "!exact", "r"), Match("suffix", "!punctuation", ""))), Rule("্রর", listOf(Match("prefix", "consonant", ""), Match("prefix", "!exact", "r"))))),
        Pattern("ry", "র‍্য", listOf(Rule("্র্য", listOf(Match("prefix", "consonant", ""), Match("prefix", "!exact", "r"), Match("prefix", "!exact", "y"), Match("prefix", "!exact", "w"), Match("prefix", "!exact", "x"))))),
        Pattern("sT", "স্ট", listOf()),
        Pattern("sf", "স্ফ", listOf()),
        Pattern("sh", "শ", listOf()),
        Pattern("sk", "স্ক", listOf()),
        Pattern("sl", "স্ল", listOf()),
        Pattern("sm", "স্ম", listOf()),
        Pattern("sn", "স্ন", listOf()),
        Pattern("sp", "স্প", listOf()),
        Pattern("st", "স্ত", listOf()),
        Pattern("th", "থ", listOf()),
        Pattern("tm", "ত্ম", listOf()),
        Pattern("tn", "ত্ন", listOf()),
        Pattern("tt", "ত্ত", listOf()),
        Pattern("u`", "ু", listOf()),
        Pattern("vl", "ভ্ল", listOf()),
        Pattern("${'$'}", "৳", listOf()),
        Pattern(",", ",", listOf()),
        Pattern(".", "।", listOf(Rule(".", listOf(Match("suffix", "number", ""))))),
        Pattern("0", "০", listOf()),
        Pattern("1", "১", listOf()),
        Pattern("2", "২", listOf()),
        Pattern("3", "৩", listOf()),
        Pattern("4", "৪", listOf()),
        Pattern("5", "৫", listOf()),
        Pattern("6", "৬", listOf()),
        Pattern("7", "৭", listOf()),
        Pattern("8", "৮", listOf()),
        Pattern("9", "৯", listOf()),
        Pattern(":", "ঃ", listOf(Rule(":", listOf(Match("suffix", "number", ""))))),
        Pattern("D", "ড", listOf()),
        Pattern("G", "গ", listOf()),
        Pattern("I", "ী", listOf(Rule("ঈ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("ঈ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("J", "জ", listOf()),
        Pattern("N", "ণ", listOf()),
        Pattern("O", "ো", listOf(Rule("ও", listOf(Match("prefix", "!consonant", ""))), Rule("ও", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("R", "ড়", listOf()),
        Pattern("S", "শ", listOf()),
        Pattern("T", "ট", listOf()),
        Pattern("U", "ূ", listOf(Rule("ঊ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("ঊ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("Y", "য়", listOf()),
        Pattern("Z", "্য", listOf()),
        Pattern("^", "ঁ", listOf()),
        Pattern("`", "", listOf()),
        Pattern("a", "া", listOf(Rule("আ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))), Rule("য়া", listOf(Match("prefix", "!consonant", ""), Match("prefix", "!exact", "a"), Match("suffix", "!exact", "`"))), Rule("আ", listOf(Match("prefix", "exact", "a"), Match("suffix", "!exact", "`"))))),
        Pattern("b", "ব", listOf()),
        Pattern("c", "চ", listOf()),
        Pattern("d", "দ", listOf()),
        Pattern("e", "ে", listOf(Rule("এ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("এ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("f", "ফ", listOf()),
        Pattern("g", "গ", listOf()),
        Pattern("h", "হ", listOf()),
        Pattern("i", "ি", listOf(Rule("ই", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("ই", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("j", "জ", listOf()),
        Pattern("k", "ক", listOf()),
        Pattern("l", "ল", listOf()),
        Pattern("m", "ম", listOf()),
        Pattern("n", "ন", listOf()),
        Pattern("o", "", listOf(Rule("ও", listOf(Match("prefix", "vowel", ""), Match("prefix", "!exact", "o"))), Rule("অ", listOf(Match("prefix", "vowel", ""), Match("prefix", "exact", "o"))), Rule("অ", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("p", "প", listOf()),
        Pattern("q", "ক", listOf()),
        Pattern("r", "র", listOf(Rule("্র", listOf(Match("prefix", "consonant", ""), Match("prefix", "!exact", "r"), Match("prefix", "!exact", "y"), Match("prefix", "!exact", "w"), Match("prefix", "!exact", "x"), Match("prefix", "!exact", "Z"))))),
        Pattern("s", "স", listOf()),
        Pattern("t", "ত", listOf()),
        Pattern("u", "ু", listOf(Rule("উ", listOf(Match("prefix", "!consonant", ""), Match("suffix", "!exact", "`"))), Rule("উ", listOf(Match("prefix", "punctuation", ""), Match("suffix", "!exact", "`"))))),
        Pattern("v", "ভ", listOf()),
        Pattern("w", "ও", listOf(Rule("ওয়", listOf(Match("prefix", "punctuation", ""), Match("suffix", "vowel", ""))), Rule("্ব", listOf(Match("prefix", "consonant", ""))))),
        Pattern("x", "ক্স", listOf(Rule("এক্স", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("y", "্য", listOf(Rule("য়", listOf(Match("prefix", "!consonant", ""), Match("prefix", "!punctuation", ""))), Rule("ইয়", listOf(Match("prefix", "punctuation", ""))))),
        Pattern("z", "য", listOf()),
    )

    private val patternMap: Map<String, Pattern> = patterns.associateBy { it.find }
    private val maxPatternLength: Int = patterns.maxOf { it.find.length }

    fun convert(input: String): String {
        val fixed = fixString(input)
        val output = StringBuilder()
        val len = fixed.length
        var cur = 0
        while (cur < len) {
            val start = cur
            var matched = false
            var chunkLen = maxPatternLength
            while (chunkLen > 0) {
                val end = start + chunkLen
                if (end <= len) {
                    val chunk = fixed.substring(start, end)
                    val pattern = patternMap[chunk]
                    if (pattern != null) {
                        if (pattern.rules.isNotEmpty()) {
                            for (rule in pattern.rules) {
                                var replaceOk = true
                                for (m in rule.matches) {
                                    if (!matchScope(m, fixed, start, end, len)) {
                                        replaceOk = false
                                        break
                                    }
                                }
                                if (replaceOk) {
                                    output.append(rule.replace)
                                    cur = end - 1
                                    matched = true
                                    break
                                }
                            }
                        }
                        if (!matched) {
                            output.append(pattern.replace)
                            cur = end - 1
                            matched = true
                        }
                    }
                }
                if (matched) break
                chunkLen--
            }
            if (!matched) {
                output.append(fixed[cur])
            }
            cur++
        }
        return output.toString()
    }

    private fun matchScope(m: Match, fixed: String, start: Int, end: Int, len: Int): Boolean {
        val isNegative = m.scope.startsWith("!")
        val scope = if (isNegative) m.scope.substring(1) else m.scope
        val type = m.type
        val chk = if (type == "suffix") end else start - 1
        val inner = when (scope) {
            "punctuation" -> (type == "prefix" && chk < 0) ||
                    (type == "suffix" && chk >= len) ||
                    (chk in 0 until len && isPunctuation(fixed[chk]))
            "vowel" -> ((type == "prefix" && chk >= 0) || (type == "suffix" && chk < len)) &&
                    chk in 0 until len && isVowel(fixed[chk])
            "consonant" -> ((type == "prefix" && chk >= 0) || (type == "suffix" && chk < len)) &&
                    chk in 0 until len && isConsonant(fixed[chk])
            "number" -> ((type == "prefix" && chk >= 0) || (type == "suffix" && chk < len)) &&
                    chk in 0 until len && isNumber(fixed[chk])
            "exact" -> {
                val s: Int
                val e: Int
                if (type == "suffix") {
                    s = end
                    e = end + m.value.length
                } else {
                    s = start - m.value.length
                    e = start
                }
                isExact(m.value, fixed, s, e)
            }
            else -> true
        }
        return inner != isNegative
    }

    private fun isExact(needle: String, heystack: String, start: Int, end: Int): Boolean {
        val l = end - start
        return (start >= 0 && end <= heystack.length && heystack.substring(start, end) == needle)
    }

    private fun fixString(input: String): String {
        val sb = StringBuilder()
        for (c in input) {
            if (isCaseSensitive(c)) sb.append(c) else sb.append(c.lowercaseChar())
        }
        return sb.toString()
    }

    private fun isVowel(c: Char): Boolean = vowel.contains(c, ignoreCase = true)
    private fun isConsonant(c: Char): Boolean = cons.contains(c, ignoreCase = true)
    private fun isPunctuation(c: Char): Boolean = !(isVowel(c) || isConsonant(c))
    private fun isNumber(c: Char): Boolean = num.contains(c, ignoreCase = true)
    private fun isCaseSensitive(c: Char): Boolean = csen.contains(c, ignoreCase = true)
}
