package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    @Test
    fun emptyToEmpty() {
        arrayOf<String>().assert(arrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        arrayOf<String>().assert(arrayOf("1"))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        arrayOf<String>().assert(arrayOf("1", "2"))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        arrayOf("2").assert(arrayOf())
    }

    @Test
    fun singleToSingleSame() {
        arrayOf("1").assert(arrayOf("1"))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        arrayOf("1").assert(arrayOf("2"))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        arrayOf("1").assert(arrayOf("1", "2"))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        arrayOf("1", "2").assert(arrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        arrayOf("1", "2").assert(arrayOf("1"))
    }

    @Test
    fun multipleToMultipleSame() {
        arrayOf("1", "2").assert(arrayOf("1", "2"))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        arrayOf("1", "1").assert(arrayOf("1", "2"))
    }
}