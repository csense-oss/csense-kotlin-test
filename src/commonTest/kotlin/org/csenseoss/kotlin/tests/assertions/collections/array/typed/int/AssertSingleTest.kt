package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSingleTest {
    @Test
    fun empty() = assertThrows<Throwable>() {
        intArrayOf().assertSingle(1)
    }

    @Test
    fun singleNotSame() = assertThrows<Throwable> {
        intArrayOf(2).assertSingle(1)
    }

    @Test
    fun singleSame() {
        intArrayOf(1).assertSingle(1)
    }

    @Test
    fun multiple() = assertThrows<Throwable> {
        intArrayOf(1, 2).assertSingle(1)
    }
}