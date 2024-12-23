package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        longArrayOf().assert(longArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        longArrayOf().assert(longArrayOf(1))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        longArrayOf().assert(longArrayOf(1, 2))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        longArrayOf(2).assert(longArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        longArrayOf(1).assert(longArrayOf(1))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        longArrayOf(1).assert(longArrayOf(2))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        longArrayOf(1).assert(longArrayOf(1, 2))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        longArrayOf(1, 2).assert(longArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        longArrayOf(1, 2).assert(longArrayOf(1))
    }

    @Test
    fun multipleToMultipleSame() {
        longArrayOf(1, 2).assert(longArrayOf(1, 2))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        longArrayOf(1, 1).assert(longArrayOf(1, 2))
    }
}