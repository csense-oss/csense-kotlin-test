package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {

    class AssertSizeExpectedCount {
        @Test
        fun nullShouldThrow() = assertThrows<Throwable> {
            val lst: List<String>? = null
            lst.assertSize(42)
        }

        @Test
        fun emptyWithSizeThrows() = assertThrows<Throwable> {
            val lst: List<String> = listOf()
            lst.assertSize(42)
        }

        @Test
        fun emptyWithZeroContinues() = assertDoesNotThrow {
            val lst: List<String> = listOf()
            lst.assertSize(0)
        }

        @Test
        fun sizeWithMatchingSizeContinues() = assertDoesNotThrow {
            val lst: List<String> = listOf("test", "1234", "qwerty")
            lst.assertSize(3)
        }

        @Test
        fun sizeWithMismatchingSizeThrows() = assertThrows<Throwable> {
            val lst: List<String> = listOf("test", "1234", "qwerty")
            lst.assertSize(42)
        }
    }

    class AssertSizeExpectedIterable {
        @Test
        fun nullShouldThrow() = assertThrows<Throwable> {
            val lst: List<String>? = null
            lst.assertSize(listOf("test"))
        }

        @Test
        fun emptyWithSizeThrows() = assertThrows<Throwable> {
            val lst: List<String> = listOf()
            lst.assertSize(listOf("test"))
        }

        @Test
        fun emptyWithZeroContinues() = assertDoesNotThrow {
            val lst: List<String> = listOf()
            lst.assertSize(lst)
        }

        @Test
        fun sizeWithMatchingSizeContinues() = assertDoesNotThrow {
            val lst: List<String> = listOf("test", "1234", "qwerty")
            lst.assertSize(lst)
        }

        @Test
        fun sizeWithMismatchingSizeThrows() = assertThrows<Throwable> {
            val lst: List<String> = listOf("test", "1234", "qwerty")
            lst.assertSize(listOf("test"))
        }
    }
}