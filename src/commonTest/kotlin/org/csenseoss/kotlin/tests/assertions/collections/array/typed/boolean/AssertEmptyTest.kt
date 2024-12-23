package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        booleanArrayOf().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        booleanArrayOf(true).assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        booleanArrayOf(false, true).assertEmpty()
    }
}