package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        charArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        charArrayOf('1').assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        charArrayOf('1', '2').assertEmpty()
    }
}