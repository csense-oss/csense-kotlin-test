package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        floatArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        floatArrayOf(1f).assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        floatArrayOf(1f, 2f).assertEmpty()
    }
}