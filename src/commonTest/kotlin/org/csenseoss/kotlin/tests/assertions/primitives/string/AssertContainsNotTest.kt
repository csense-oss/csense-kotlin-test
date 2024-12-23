package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertContainsNotTest {

    @Test
    fun emptyString() {
        "".assertContainsNot("test")
        assertThrows<Throwable> {
            "".assertContainsNot("")
        }
    }

    @Test
    fun singleWord() {
        assertThrows<Throwable> {
            "asd".assertContainsNot("asd")
        }
        "asd".assertContainsNot("test")
    }

    @Test
    fun multipleWords() {
        assertThrows<Throwable> {
            "asd test".assertContainsNot("test")
        }
        "asd 123".assertContainsNot("test")
    }


    @Test
    fun singleWordCasing() {
        assertThrows<Throwable> {
            "asd".assertContainsNot("ASD", ignoreCase = true)
        }
        "asd".assertContainsNot("AsD", ignoreCase = false)
    }

    @Test
    fun multipleWordsCasing() {
        assertThrows<Throwable> {
            "asd tESt".assertContainsNot("TesT", ignoreCase = true)
        }
        "asd 123".assertContainsNot("asD", ignoreCase = false)
    }
}