package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.primitives.charSequence.*
import kotlin.test.*

class AssertNotTest {
    @Test
    fun stringAssertNot() {
        "".assertNot("test")
        assertThrows<Throwable> {
            "".assertNot("")
        }
        assertThrows<Throwable> {
            "test".assertNot("test")
        }
        "test".assertNot("")

        assertThrows<Throwable> {
            "tESt".assertNot("TesT", ignoreCase = true)
        }

        "tesT".assertNot("test", ignoreCase = false)

        assertThrows<Throwable> {
            "Test".assertNot("test", ignoreCase = true)
        }
        "tesT".assertNot("Test", ignoreCase = false)


    }
}