package org.charclie

import org.charlie.CuidUtils
import org.junit.Test

class CuidUtilsTest {
    @Test
    fun testEncode() {
        val source = "53EB9DEDC2207C894D7A99FADA5460E4"

        println(CuidUtils.encode(source))
    }

    @Test
    fun decoded() {
        val s = "我爱北京天安门"
        println(s.toByteArray().size)

        val encode = "EE49C4-DFF51B-C31BG8-F83344-BD2D20-G7"
        println(CuidUtils.decode(encode))

        val encode2 = "7CG982-6BFG46-E5C61F-2387G9-578263-1B"
        println(CuidUtils.decode(encode2))
    }
}
