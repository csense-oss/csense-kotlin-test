package org.csenseoss.kotlin.tests.assertions.collections.array

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.comparable.*


public object ArrayAssertions {
    /**
     * Asserts that [givenArray] and [expected] match in size, and element at a given location
     */
    public fun <T, U : Comparable<U>> assertArrays(
        givenArray: T,
        expected: T,
        message: String,
        getSize: T.() -> Int,
        getElementAt: T.(index: Int) -> U
    ) {
        assertArraysBy(
            givenArray = givenArray,
            expected = expected,
            message = message,
            getSize = getSize,
            getElementAt = getElementAt,
            assert = { actual: U, expectedItem: U, resultMessage: String ->
                actual.assert(expected = expectedItem, message = resultMessage)
            }
        )
    }

    public fun <T, U> assertArraysBy(
        givenArray: T,
        expected: T,
        message: String,
        getSize: T.() -> Int,
        getElementAt: T.(index: Int) -> U,
        assert: (actual: U, expected: U, message: String) -> Unit
    ) {
        assertArraysSameSize(givenArray, expected, getSize)
        val size: Int = expected.getSize()
        for (index: Int in 0 until size) {
            val thisItem: U = givenArray.getElementAt(index)
            val expectedItem: U = expected.getElementAt(index)
            assert(
                thisItem,
                expectedItem,
                "$message.Failed at index $index, with byte: $thisItem, expected $expectedItem"
            )
        }
    }

    private fun <T> assertArraysSameSize(
        givenArray: T,
        expected: T,
        getSize: T.() -> Int
    ) {
        val givenSize: Int = givenArray.getSize()
        val expectedSize: Int = expected.getSize()
        givenSize.assert(
            expectedSize,
            message = "Expected this to have same number($givenSize of elements as the expected ($expectedSize)"
        )
    }
}