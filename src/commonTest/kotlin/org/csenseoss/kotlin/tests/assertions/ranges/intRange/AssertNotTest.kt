package org.csenseoss.kotlin.tests.assertions.ranges.intRange

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotTest {
    @Test
    fun mismatchContinues() = assertDoesNotThrow {
        IntRange(start = 0, endInclusive = 42).assertNot(IntRange.EMPTY)
    }

    @Test
    fun matchThrows() = assertThrows<Throwable> {
        val range = IntRange(start = 0, endInclusive = 42)
        range.assertNot(range)
    }
}