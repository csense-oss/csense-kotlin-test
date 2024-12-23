package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        doubleArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        doubleArrayOf(1.0).assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        doubleArrayOf(1.0, 2.0).assertEmpty()
    }
}