package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.primitives.charSequence.*
import kotlin.test.*

class AssertStartsWithTest {

    @Test
    fun stringAssertStartsWith() {
        "".assertStartsWith("")
        assertThrows<Throwable> {
            "".assertStartsWith("test")
        }
        assertThrows<Throwable> {
            "a test".assertStartsWith("test")
        }
        "test".assertStartsWith("test")
        "test abc 123".assertStartsWith("test")

        assertThrows<Throwable> {
            "TeSt".assertStartsWith("tesT", ignoreCase = false)
        }
        "TeSt".assertStartsWith("tEsT", ignoreCase = true)
    }
}