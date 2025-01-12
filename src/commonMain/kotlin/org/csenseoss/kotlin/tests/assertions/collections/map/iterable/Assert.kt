@file:Suppress("NOTHING_TO_INLINE")

package org.csenseoss.kotlin.tests.assertions.collections.map.iterable

import org.csenseoss.kotlin.tests.assertions.collections.helpers.*
import org.csenseoss.kotlin.tests.assertions.collections.iterable.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


public inline fun <K, V> Map<K, Iterable<V>>?.assert(
    expected: Map<K, Iterable<V>>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { lhs: Map.Entry<K, Iterable<V>>, rhs: Map.Entry<K, Iterable<V>> ->
            lhs.key.assert(expected = rhs.key, message = message)
            lhs.value.assert(expected = rhs.value, message = message)
        },
        messageIfDifferentSizes = ""
    )
}


public inline fun <K, V> Map<K, Iterable<V>>?.assert(
    vararg expected: Pair<K, Iterable<V>>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { lhs: Map.Entry<K, Iterable<V>>, rhs: Pair<K, Iterable<V>> ->
            lhs.key.assert(expected = rhs.first, message = message)
            lhs.value.assert(expected = rhs.second, message = message)
        },
        messageIfDifferentSizes = ""
    )
}

public inline fun <K, V> Map<K, Iterable<V>>?.assert(
    vararg expected: Map.Entry<K, Iterable<V>>,
    message: String = ""
) where K : Comparable<K>, V : Comparable<V> {
    contract { returns() implies (this@assert != null) }
    assertNotNull()
    DualIterator.onDualIterator(
        actualIterator = iterator(),
        expectedIterator = expected.iterator(),
        action = { lhs: Map.Entry<K, Iterable<V>>, rhs: Map.Entry<K, Iterable<V>> ->
            lhs.key.assert(expected = rhs.key, message = message)
            lhs.value.assert(expected = rhs.value, message = message)
        },
        messageIfDifferentSizes = ""
    )
}