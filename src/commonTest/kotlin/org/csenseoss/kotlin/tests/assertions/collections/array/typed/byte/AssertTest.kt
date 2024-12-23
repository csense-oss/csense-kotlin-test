package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        byteArrayOf().assert(byteArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        byteArrayOf().assert(byteArrayOf(1))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        byteArrayOf().assert(byteArrayOf(1, 2))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        byteArrayOf(2).assert(byteArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        byteArrayOf(1).assert(byteArrayOf(1))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        byteArrayOf(1).assert(byteArrayOf(2))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        byteArrayOf(1).assert(byteArrayOf(1, 2))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        byteArrayOf(1, 2).assert(byteArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        byteArrayOf(1, 2).assert(byteArrayOf(1))
    }

    @Test
    fun multipleToMultipleSame() {
        byteArrayOf(1, 2).assert(byteArrayOf(1, 2))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        byteArrayOf(1, 1).assert(byteArrayOf(1, 2))
    }
}