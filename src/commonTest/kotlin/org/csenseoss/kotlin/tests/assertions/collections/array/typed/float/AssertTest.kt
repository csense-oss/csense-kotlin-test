package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        floatArrayOf().assert(floatArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        floatArrayOf().assert(floatArrayOf(1f))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        floatArrayOf().assert(floatArrayOf(1f, 2f))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        floatArrayOf(2f).assert(floatArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        floatArrayOf(1f).assert(floatArrayOf(1f))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        floatArrayOf(1f).assert(floatArrayOf(2f))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        floatArrayOf(1f).assert(floatArrayOf(1f, 2f))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        floatArrayOf(1f, 2f).assert(floatArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        floatArrayOf(1f, 2f).assert(floatArrayOf(1f))
    }

    @Test
    fun multipleToMultipleSame() {
        floatArrayOf(1f, 2f).assert(floatArrayOf(1f, 2f))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        floatArrayOf(1f, 1f).assert(floatArrayOf(1f, 2f))
    }
}