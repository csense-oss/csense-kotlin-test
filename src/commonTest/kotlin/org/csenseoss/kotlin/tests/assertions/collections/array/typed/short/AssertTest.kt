package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        shortArrayOf().assert(shortArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        shortArrayOf().assert(shortArrayOf(1))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        shortArrayOf().assert(shortArrayOf(1, 2))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        shortArrayOf(2).assert(shortArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        shortArrayOf(1).assert(shortArrayOf(1))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        shortArrayOf(1).assert(shortArrayOf(2))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        shortArrayOf(1).assert(shortArrayOf(1, 2))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        shortArrayOf(1, 2).assert(shortArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        shortArrayOf(1, 2).assert(shortArrayOf(1))
    }

    @Test
    fun multipleToMultipleSame() {
        shortArrayOf(1, 2).assert(shortArrayOf(1, 2))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        shortArrayOf(1, 1).assert(shortArrayOf(1, 2))
    }
}