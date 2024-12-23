package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun stringAssertEmpty() {

        "".assertEmpty()
        assertThrows<Throwable> {
            " ".assertEmpty()
        }

    }
}