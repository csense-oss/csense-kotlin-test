package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {

    class Assert {
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


    class AssertVararg {
        @Test
        fun emptyToEmpty() {
            intArrayOf().assert()
        }

        @Test
        fun contentToEmpty(): Unit = assertThrows<Throwable> {
            intArrayOf(42).assert()
        }

        @Test
        fun singleToSingleMatching() {
            intArrayOf(42).assert(42)
        }

        @Test
        fun singleToSingleMisMatching(): Unit = assertThrows<Throwable> {
            intArrayOf(42).assert(11)
        }

        @Test
        fun multipleMismatching(): Unit = assertThrows<Throwable> {
            intArrayOf(42, 22, 33).assert(42, 11, 33)
        }

        @Test
        fun multipleMatching() {
            intArrayOf(42,11,45).assert(42, 11, 45)
        }
    }
}