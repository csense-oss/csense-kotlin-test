package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        shortArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable>() {
        shortArrayOf(1).assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        shortArrayOf(1, 2).assertEmpty()
    }
}