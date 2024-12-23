package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun shouldWorkOnNormalNonNullStrings() {
        "".assert("")
        assertThrows<Throwable> {
            "".assert("test")
        }
        assertThrows<Throwable> {
            "test".assert("")
        }
        "test".assert("test")

        assertThrows<Throwable> {
            "tesT".assert("test", ignoreCase = false)
        }
        assertThrows<Throwable> {
            "tesT".assert("Test", ignoreCase = false)
        }

        "Test".assert("test", ignoreCase = true)

        "tESt".assert("TesT", ignoreCase = true)
    }

    @Test
    fun assertShouldWorkOnNullableString() = assertThrows<Throwable> {
        val str: String? = null
        str.assert("")
    }

    @Test
    fun assertShouldWorkOnNullableIgnoreCaseString() = assertThrows<Throwable> {
        val str: String? = null
        str.assert("abC", ignoreCase = true)
    }


}