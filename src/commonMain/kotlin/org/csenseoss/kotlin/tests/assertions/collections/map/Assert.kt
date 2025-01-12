@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.collections.helpers.*
import org.csenseoss.kotlin.tests.assertions.collections.map.entry.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


public inline fun <K, V> Map<K, V>?.assert(
    expected: Map<K, V>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    size.assert(expected.size, "expected map to have size ${expected.size} but has $size")

    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { actualItem: Map.Entry<K,V>, expectedItem: Map.Entry<K,V> ->
            actualItem.assert(expected = expectedItem, message = message)
        },
        messageIfDifferentSizes = "Expected to have ${expected.count()} items, but is ${count()}"
    )

}

public inline fun <K, V> Map<K, V>?.assert(
    vararg expected: Pair<K, V>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { actualItem: Map.Entry<K,V>, expectedItem: Pair<K, V> ->
            actualItem.assert(expected = expectedItem, message = message)
        },
        messageIfDifferentSizes = "Expected to have ${expected.count()} items, but is ${count()}"
    )
}

public inline fun <K, V> Map<K, V>?.assert(
    vararg expected: Map.Entry<K, V>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { actualItem: Map.Entry<K,V>, expectedItem: Map.Entry<K, V> ->
            actualItem.assert(expected = expectedItem, message = message)
        },
        messageIfDifferentSizes = "Expected to have ${expected.count()} items, but is ${count()}"
    )
}