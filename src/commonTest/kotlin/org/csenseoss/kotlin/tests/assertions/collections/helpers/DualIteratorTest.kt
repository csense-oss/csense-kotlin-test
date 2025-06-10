package org.csenseoss.kotlin.tests.assertions.collections.helpers

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.test.*

class DualIteratorTest {

    class OnDualIterator {
        @Test
        fun emptyToEmpty() = assertDoesNotThrow {
            val actual: List<String> = listOf()
            val expected: List<String> = listOf()
            DualIterator.onDualIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun singleToEmptyShouldThrow() = assertThrows<Throwable> {
            val actual: List<String> = listOf("test")
            val expected: List<String> = listOf()
            DualIterator.onDualIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun emptyToSingleShouldThrow() = assertThrows<Throwable> {
            val actual: List<String> = listOf()
            val expected: List<String> = listOf("test")
            DualIterator.onDualIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun singleToSingle() = assertCalled { shouldBeCalled ->
            val actual: List<String> = listOf("actual")
            val expected: List<String> = listOf("expected")
            DualIterator.onDualIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { actual: String, expected: String ->
                    actual.assert("actual")
                    expected.assert("expected")
                    shouldBeCalled()
                },
                messageIfDifferentSizes = ""
            )
        }
    }

    class OnDualNullableIterator {
        @Test
        fun emptyToEmpty() = assertDoesNotThrow {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun nullToEmptyShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf(null)
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun emptyToNullShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf(null)
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun nullToNullShouldWork() = assertDoesNotThrow {
            val actual: List<String?> = listOf(null)
            val expected: List<String?> = listOf(null)
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled("null is checked outside of action") },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun singleToEmptyShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf("test")
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun emptyToSingleShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf("test")
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { _, _ -> shouldNotBeCalled() },
                messageIfDifferentSizes = ""
            )
        }

        @Test
        fun singleToSingle() = assertCalled { shouldBeCalled ->
            val actual: List<String?> = listOf("actual")
            val expected: List<String?> = listOf("expected")
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                action = { actual: String, expected: String ->
                    actual.assert("actual")
                    expected.assert("expected")
                    shouldBeCalled()
                },
                messageIfDifferentSizes = ""
            )
        }
    }

    class OnDualNullableIteratorComparable {
        @Test
        fun emptyToEmpty() = assertDoesNotThrow {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun nullToEmptyShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf(null)
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun emptyToNullShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf(null)
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun nullToNullShouldWork() = assertDoesNotThrow {
            val actual: List<String?> = listOf(null)
            val expected: List<String?> = listOf(null)
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun singleToEmptyShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf("test")
            val expected: List<String?> = listOf()
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun emptyToSingleShouldThrow() = assertThrows<Throwable> {
            val actual: List<String?> = listOf()
            val expected: List<String?> = listOf("test")
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }

        @Test
        fun singleToSingle() = assertDoesNotThrow {
            val actual: List<String?> = listOf("test")
            val expected: List<String?> = listOf("test")
            DualIterator.onDualNullableIterator(
                actualIterator = actual.iterator(),
                expectedIterator = expected.iterator(),
                message = ""
            )
        }
    }
}