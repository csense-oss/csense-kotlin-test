package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        doubleArrayOf().assert(doubleArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        doubleArrayOf().assert(doubleArrayOf(1.0))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        doubleArrayOf().assert(doubleArrayOf(1.0, 2.0))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        doubleArrayOf(2.0).assert(doubleArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        doubleArrayOf(1.0).assert(doubleArrayOf(1.0))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        doubleArrayOf(1.0).assert(doubleArrayOf(2.0))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        doubleArrayOf(1.0).assert(doubleArrayOf(1.0, 2.0))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        doubleArrayOf(1.0, 2.0).assert(doubleArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        doubleArrayOf(1.0, 2.0).assert(doubleArrayOf(1.0))
    }

    @Test
    fun multipleToMultipleSame() {
        doubleArrayOf(1.0, 2.0).assert(doubleArrayOf(1.0, 2.0))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        doubleArrayOf(1.0, 1.0).assert(doubleArrayOf(1.0, 2.0))
    }
}