package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.primitives.charSequence.*
import kotlin.test.*

class AssertEndsWithTest {

    @Test
    fun stringAssertEndsWith() {
        "".assertEndsWith("")
        assertThrows<Throwable> {
            "".assertEndsWith("test")
        }
        assertThrows<Throwable> {
            "test abc 123".assertEndsWith("test")
        }
        "a test".assertEndsWith("test")
        "test".assertEndsWith("test")

        assertThrows<Throwable> {
            "TeSt".assertEndsWith("tesT", ignoreCase = false)
        }
        "TeSt".assertEndsWith("tEsT", ignoreCase = true)
    }
}