package org.csenseoss.kotlin.tests.assertions.ranges.intRange

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    @Test
    fun shouldThrowWhenNoOverlap() {
        val range: IntRange = 0 until 10
        val otherRange: IntRange = 20 until 100
        assertThrows<Throwable> {
            range.assert(otherRange)
        }

        val subRange:IntRange = 5 until 7
        assertThrows<Throwable> {
            range.assert(subRange)
        }
    }

    @Test
    fun sameRangeShouldBeOk() {
        val range: IntRange = 0 until 10
        range.assert(0 until 10)
    }
}