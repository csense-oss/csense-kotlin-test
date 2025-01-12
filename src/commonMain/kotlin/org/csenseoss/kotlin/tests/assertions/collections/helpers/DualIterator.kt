@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.helpers

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.comparable.*

//TODO better name
public object DualIterator {
    public inline fun <Actual, Expected> onDualIterator(
        actualIterator: Iterator<Actual>,
        expectedIterator: Iterator<Expected>,
        action: (actualItem: Actual, expectedItem: Expected) -> Unit,
        messageIfDifferentSizes: String
    ) {

        while (actualIterator.hasNext() && expectedIterator.hasNext()) {
            val actualItem: Actual = actualIterator.next()
            val expectedItem: Expected = expectedIterator.next()
            action(actualItem, expectedItem)
        }

        actualIterator.hasNext().assert(
            expected = expectedIterator.hasNext(),
            message = messageIfDifferentSizes
        )
    }

    public inline fun <Type : Comparable<Type>> onDualNullableIterator(
        actualIterator: Iterator<Type?>,
        expectedIterator: Iterator<Type?>,
        messageIfDifferentSizes: String = "",
        message: String
    ): Unit = onDualNullableIterator(
        actualIterator = actualIterator,
        expectedIterator = expectedIterator,
        action = { lhs: Type, rhs: Type ->
            lhs.assert(rhs, message)
        },
        messageIfDifferentSizes = messageIfDifferentSizes
    )

    public inline fun <Actual, Expected> onDualNullableIterator(
        actualIterator: Iterator<Actual?>,
        expectedIterator: Iterator<Expected?>,
        action: (actualItem: Actual, expectedItem: Expected) -> Unit,
        messageIfDifferentSizes: String
    ): Unit = onDualIterator(
        actualIterator = actualIterator,
        expectedIterator = expectedIterator,
        action = { actualItemNullable: Actual?, expectedItemNullable: Expected? ->
            Nullabillity.assertNullabillityEqualsOr(
                actual = actualItemNullable,
                expected = expectedItemNullable,
                orByAssert = action
            )
        },
        messageIfDifferentSizes = messageIfDifferentSizes
    )

}