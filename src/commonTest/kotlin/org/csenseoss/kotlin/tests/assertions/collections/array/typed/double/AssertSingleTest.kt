package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSingleTest {
    @Test
    fun empty() = assertThrows<Throwable> {
        doubleArrayOf().assertSingle(1.0)
    }

    @Test
    fun singleNotSame() = assertThrows<Throwable> {
        doubleArrayOf(2.0).assertSingle(1.0)
    }

    @Test
    fun singleSame() {
        doubleArrayOf(1.0).assertSingle(1.0)
    }

    @Test
    fun multiple() = assertThrows<Throwable> {
        doubleArrayOf(1.0, 2.0).assertSingle(1.0)
    }
}