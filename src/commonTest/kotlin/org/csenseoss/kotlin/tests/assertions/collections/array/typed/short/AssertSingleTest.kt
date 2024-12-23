package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSingleTest {
    @Test
    fun empty() = assertThrows<Throwable>() {
        shortArrayOf().assertSingle(1)
    }

    @Test
    fun singleNotSame() = assertThrows<Throwable> {
        shortArrayOf(2).assertSingle(1)
    }

    @Test
    fun singleSame() {
        shortArrayOf(1).assertSingle(1)
    }

    @Test
    fun multiple() = assertThrows<Throwable> {
        shortArrayOf(1, 2).assertSingle(1)
    }
}