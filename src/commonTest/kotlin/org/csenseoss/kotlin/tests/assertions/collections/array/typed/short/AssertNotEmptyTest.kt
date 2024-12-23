package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable> {
        shortArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        shortArrayOf(1).assertNotEmpty()
    }


    @Test
    fun multiple() {
        shortArrayOf(1, 2).assertNotEmpty()
    }
}