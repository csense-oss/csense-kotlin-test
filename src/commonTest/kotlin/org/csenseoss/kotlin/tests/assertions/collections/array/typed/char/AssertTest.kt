package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    @Test
    fun emptyToEmpty() {
        charArrayOf().assert(charArrayOf())
    }

    @Test
    fun emptyToSingle() = assertThrows<Throwable> {
        charArrayOf().assert(charArrayOf('a'))
    }

    @Test
    fun emptyToMultiple() = assertThrows<Throwable> {
        charArrayOf().assert(charArrayOf('a', 'b'))
    }

    @Test
    fun singleToEmpty() = assertThrows<Throwable> {
        charArrayOf('b').assert(charArrayOf())
    }

    @Test
    fun singleToSingleSame() {
        charArrayOf('a').assert(charArrayOf('a'))
    }

    @Test
    fun singleToSingleDifferent() = assertThrows<Throwable> {
        charArrayOf('a').assert(charArrayOf('b'))
    }

    @Test
    fun singleToMultiple() = assertThrows<Throwable> {
        charArrayOf('a').assert(charArrayOf('a', 'b'))
    }

    @Test
    fun multipleToEmpty() = assertThrows<Throwable> {
        charArrayOf('a', 'b').assert(charArrayOf())
    }

    @Test
    fun multipleToSingle() = assertThrows<Throwable> {
        charArrayOf('a', 'b').assert(charArrayOf('a'))
    }

    @Test
    fun multipleToMultipleSame() {
        charArrayOf('a', 'b').assert(charArrayOf('a', 'b'))
    }

    @Test
    fun multipleToMultipleDifferent() = assertThrows<Throwable> {
        charArrayOf('a', 'a').assert(charArrayOf('a', 'b'))
    }
}