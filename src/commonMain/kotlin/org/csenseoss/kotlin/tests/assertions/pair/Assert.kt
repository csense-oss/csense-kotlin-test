package org.csenseoss.kotlin.tests.assertions.pair

import org.csenseoss.kotlin.tests.assertions.comparable.*

public fun <First, Second> Pair<First, Second>.assert(
    expected: Pair<First, Second>,
    message: String = "Expected \"$expected\" but is different to \"$this\""
) where First : Comparable<First>, Second : Comparable<Second> {
    expected.first.assert(first, message)
    expected.second.assert(second, message)
}

public fun <First, Second> Pair<First, Second>.assert(
    expectedFirst: First,
    expectedSecond: Second,
    message: String = "Expected \"($expectedFirst,$expectedSecond)\" but is different to \"$this\""
) where First : Comparable<First>, Second : Comparable<Second> {
    expectedFirst.assert(first, message)
    expectedSecond.assert(second, message)
}


public fun <First, Second> Pair<First, Second>.assert(
    expected: Map.Entry<First, Second>,
    message: String = "Expected \"$expected\" but is different to \"$this\""
) where First : Comparable<First>, Second : Comparable<Second> {
    expected.key.assert(first, message)
    expected.value.assert(second, message)
}