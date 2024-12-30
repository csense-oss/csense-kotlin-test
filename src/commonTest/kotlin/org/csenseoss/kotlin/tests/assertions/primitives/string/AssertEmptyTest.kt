package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.primitives.charSequence.*
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