package org.csenseoss.kotlin.tests.assertions.pair.iterable

import org.csenseoss.kotlin.tests.assertions.collections.iterable.*
import org.csenseoss.kotlin.tests.assertions.comparable.*
import kotlin.jvm.*

public fun <F, S> Pair<F, Iterable<S>>.assert(
    expected: Pair<F, Iterable<S>>,
    message: String = ""
) where F : Comparable<F>, S : Comparable<S> {
    first.assert(expected = expected.first, message = message)
    second.assert(expected = expected.second, message = message)
}

@JvmName("assertPairIterable")
public fun <F, S> Pair<Iterable<F>, S>.assert(
    expected: Pair<Iterable<F>, S>,
    message: String = ""
) where F : Comparable<F>, S : Comparable<S> {
    first.assert(expected = expected.first, message = message)
    second.assert(expected = expected.second, message = message)
}