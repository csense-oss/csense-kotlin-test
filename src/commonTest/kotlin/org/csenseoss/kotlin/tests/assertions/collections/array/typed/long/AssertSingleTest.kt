package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSingleTest {
    @Test
    fun empty() = assertThrows<Throwable>() {
        longArrayOf().assertSingle(1)
    }

    @Test
    fun singleNotSame() = assertThrows<Throwable> {
        longArrayOf(2).assertSingle(1)
    }

    @Test
    fun singleSame() {
        longArrayOf(1).assertSingle(1)
    }

    @Test
    fun multiple() = assertThrows<Throwable> {
        longArrayOf(1, 2).assertSingle(1)
    }
}