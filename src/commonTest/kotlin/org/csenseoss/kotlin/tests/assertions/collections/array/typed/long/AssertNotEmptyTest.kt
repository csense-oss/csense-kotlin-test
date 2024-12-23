package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable> {
        longArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        longArrayOf(1).assertNotEmpty()
    }


    @Test
    fun multiple() {
        longArrayOf(1, 2).assertNotEmpty()
    }
}