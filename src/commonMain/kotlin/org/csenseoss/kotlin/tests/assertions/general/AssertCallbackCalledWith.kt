package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.comparable.*

/**
 * Asserts that the given [testCode] will have the given items in order (and called that exact amount of times)
 * @param expectedItemsInOrder Collection<T>
 * @param assertFunction Function2<T, T, Boolean>
 * @param testCode Function1<Function1<T, Unit>, Unit>
 */
public inline fun <reified T> assertCallbackCalledWith(
    expectedItemsInOrder: Collection<T>,
    crossinline assertFunction: (T, T) -> Boolean,
    testCode: ((T) -> Unit) -> Unit,
): Unit = assertCalled(times = expectedItemsInOrder.size) { shouldBeCalled ->
    val iterator: Iterator<T> = expectedItemsInOrder.iterator()
    val callback: (T) -> Unit = { actual: T ->
        if (!iterator.hasNext()) {
            failTest(
                "Tried to access next element but was not in the expectedItemsInOrder." +
                        " You have called the assert function more than ${expectedItemsInOrder.size} times"
            )
        }
        val expected: T = iterator.next()
        val isEqual: Boolean = assertFunction(actual, expected)
        if (isEqual.not()) {
            failTest("Expected \"$actual\" to be \"$expected\"")
        }
        shouldBeCalled()
    }
    testCode(callback)
}

/**
 * Asserts that the given [testCode] will have the given items in order (and called that exact amount of times)
 * @param expectedItemsInOrder Collection<T>
 * @param assertFunction Function2<T, T, Boolean>
 * @param testCode Function1<Function1<T, Unit>, Unit>
 */
public inline fun <reified T: Comparable<T>> assertCallbackCalledWith(
    expectedItemsInOrder: Collection<T>,
    testCode: ((T) -> Unit) -> Unit,
): Unit = assertCalled(times = expectedItemsInOrder.size) { shouldBeCalled ->
    val iterator: Iterator<T> = expectedItemsInOrder.iterator()
    val callback: (T) -> Unit = { actual: T ->
        if (!iterator.hasNext()) {
            failTest(
                "Tried to access next element but was not in the expectedItemsInOrder." +
                        " You have called the assert function more than ${expectedItemsInOrder.size} times"
            )
        }
        val expected: T = iterator.next()
        actual.assert(expected)
        shouldBeCalled()
    }
    testCode(callback)
}