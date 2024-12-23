package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertContainsTest {
    @Test
    fun emptyString() {
        "".assertContains("")
        assertThrows<Throwable> {
            "".assertContains("test")
        }
    }

    @Test
    fun singleWord() {
        assertThrows<Throwable> {
            "asd".assertContains("test")
        }
        "asd".assertContains("asd")
    }

    @Test
    fun multipleWords() {
        assertThrows<Throwable> {
            "asd 123".assertContains("test")
        }
        "asd test".assertContains("test")
    }


    @Test
    fun singleWordCasing() {
        assertThrows<Throwable> {
            "asd".assertContains("AsD", ignoreCase = false)
        }
        "asd".assertContains("ASD", ignoreCase = true)
    }

    @Test
    fun multipleWordsCasing() {
        assertThrows<Throwable> {
            "asd 123".assertContains("asD", ignoreCase = false)
        }
        "asd tESt".assertContains("TesT", ignoreCase = true)
    }
}