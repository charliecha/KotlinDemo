package org.charclie

import org.charlie.CuidUtils
import org.junit.Test
import java.io.File

class CuidUtilsTest {
    @Test
    fun testEncode() {
        val source = "53EB9DEDC2207C894D7A99FADA5460E4"

        println(CuidUtils.encode(source))
    }

    @Test
    fun decoded() {
        val encode = "EE49C4-DFF51B-C31BG8-F83344-BD2D20-G7"
        println(CuidUtils.decode(encode))

        val encode2 = "7CG982-6BFG46-E5C61F-2387G9-578263-1B"
        println(CuidUtils.decode(encode2))
    }

    @Test
    fun decodeFile() {
        val set = HashSet<String>()
        val inFile = File("d:/input.txt")
        val lines = inFile.readLines()
        val outFile = File("d:/output.txt")
        outFile.delete()
        for (line in lines) {
            if (set.contains(line)) {
                continue
            }

            set.add(line)
            outFile.appendText(CuidUtils.decode(line))
            outFile.appendText("\n")
        }
    }
}
