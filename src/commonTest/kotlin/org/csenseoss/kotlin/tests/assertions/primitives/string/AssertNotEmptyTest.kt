package org.csenseoss.kotlin.tests.assertions.primitives.string

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun stringAssertNotEmpty() {
        assertThrows<Throwable> {
            "".assertNotEmpty()
        }
        " ".assertNotEmpty()
    }

}