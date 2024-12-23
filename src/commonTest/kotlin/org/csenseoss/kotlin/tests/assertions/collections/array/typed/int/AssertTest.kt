package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        intArrayOf().assert(intArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        intArrayOf().assert(intArrayOf(1))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        intArrayOf().assert(intArrayOf(1, 2))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        intArrayOf(2).assert(intArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        intArrayOf(1).assert(intArrayOf(1))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        intArrayOf(1).assert(intArrayOf(2))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        intArrayOf(1).assert(intArrayOf(1, 2))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        intArrayOf(1, 2).assert(intArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        intArrayOf(1, 2).assert(intArrayOf(1))
    }

    @Test
    fun multipleToMultipleSame() {
        intArrayOf(1, 2).assert(intArrayOf(1, 2))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        intArrayOf(1, 1).assert(intArrayOf(1, 2))
    }
}