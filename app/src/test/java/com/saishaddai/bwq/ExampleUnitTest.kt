package com.saishaddai.bwq

import org.junit.Test

import org.junit.Assert.*
import java.sql.SQLException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

//    fun isValidIdentifier(s: String) /*: Boolean*/ {
//////        val listOfRegisters : List<String>
////        var resultStatus: Int
//        resultStatus
//        resultStatus = try {
//            Integer.parseInt("")
//        } catch (e: SQLException) {
//            return  false
//        }
        //throw SQLException("mi message")
        //return s in "a".."z" || s in "A".."Z" || s.startsWith('_') && !s.contains("$")
//        val s : String = "walla"
//        println(s.length)
//        return true
//    }

    fun parseId(id: String) : Int {
        return try {
            Integer.parseInt(id)
        } catch(e:  NumberFormatException) {
            return 0
        }
    }
//    fun main(args: Array<String>) {
//        println(isValidIdentifier("name"))   // true
//        println(isValidIdentifier("_name"))  // true
//        println(isValidIdentifier("_12"))    // true
//        println(isValidIdentifier(""))       // false
//        println(isValidIdentifier("012"))    // false
//        println(isValidIdentifier("no$"))    // false
//    }

    @Test
    fun addition_isCorrect() {
        assertEquals(0, parseId(""))
        assertEquals(3, parseId("3"))
        assertEquals(0, parseId("d"))

//        assertTrue(isValidIdentifier("name"))
//        assertTrue(isValidIdentifier("_name"))
//        assertTrue(isValidIdentifier("_12"))
//        assertFalse(isValidIdentifier(""))
//        assertFalse(isValidIdentifier("012"))
//        assertFalse(isValidIdentifier("no$"))
//        assertEquals(4, 2 + 2)
    }
}
