package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        booleanArrayOf().assert(booleanArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        booleanArrayOf().assert(booleanArrayOf(true))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        booleanArrayOf().assert(booleanArrayOf(true, false))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        booleanArrayOf(false).assert(booleanArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        booleanArrayOf(true).assert(booleanArrayOf(true))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        booleanArrayOf(true).assert(booleanArrayOf(false))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        booleanArrayOf(true).assert(booleanArrayOf(true, false))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        booleanArrayOf(true, false).assert(booleanArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        booleanArrayOf(true, false).assert(booleanArrayOf(true))
    }

    @Test
    fun multipleToMultipleSame() {
        booleanArrayOf(true, false).assert(booleanArrayOf(true, false))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        booleanArrayOf(true, true).assert(booleanArrayOf(true, false))
    }

}