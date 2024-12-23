package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        intArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        intArrayOf(42).assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        intArrayOf(11, 42).assertEmpty()
    }
}