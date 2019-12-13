package org.charlie

/**
 * Cuid 工具类
 */
object CuidUtils {
    private const val STEP = 6
    private const val separator = '-'

    fun encode(source: String): String {
        return addSeparatorsWithEncode(source, separator, STEP)
    }

    fun decode(encoded: String): String {
        return removeSeparatorsWithDecode(encoded, separator, STEP)
    }

    private fun addSeparatorsWithEncode(source: String, separator: Char, step: Int): String {
        if (isEmpty(source)) {
            return ""
        }

        val builder = StringBuilder()
        val chs = source.toCharArray()
        for (i in chs.indices) {
            if (0 != i && 0 == i % step) {
                builder.append(separator)
            }
            builder.append(encodeChar(chs[i]))
        }
        return builder.toString()
    }

    private fun encodeChar(ch: Char): Char {
        if (ch == 'z') {
            return 'a'
        } else if (ch == 'Z') {
            return 'A'
        } else if (ch == '9') {
            return '0'
        } else if (ch in 'A'..'Y'
                || ch in 'a'..'y' || ch in '0'..'8') {
            return (ch.toInt() + 1).toChar()
        }
        return ch
    }

    private fun isEmpty(source: String?): Boolean {
        return null == source || "" == source
    }

    private fun removeSeparatorsWithDecode(source: String, separator: Char, step: Int): String {
        if (isEmpty(source)) {
            return ""
        }

        val builder = StringBuilder()
        val chs = source.toCharArray()
        for (i in chs.indices) {
            if (step == i % (step + 1) && separator == chs[i]) {
                continue
            }
            builder.append(decodeChar(chs[i]))
        }
        return builder.toString()
    }

    private fun decodeChar(ch: Char): Char {
        if (ch == 'a') {
            return 'z'
        } else if (ch == 'A') {
            return 'Z'
        } else if (ch == '0') {
            return '9'
        } else if (ch in 'B'..'Z'
                || ch in 'b'..'z' || ch in '1'..'9') {
            return (ch.toInt() - 1).toChar()
        }
        return ch
    }
}
