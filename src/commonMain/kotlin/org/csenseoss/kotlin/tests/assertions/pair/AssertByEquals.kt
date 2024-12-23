package org.csenseoss.kotlin.tests.assertions.pair

import org.csenseoss.kotlin.tests.assertions.general.*

public fun <First, Second> Pair<First, Second>.assertByEquals(
    expected: Pair<First, Second>,
    message: String = "Expected $expected to equal $this by equals, but was not"
) {
    expected.first.assertByEquals(first, message)
    expected.second.assertByEquals(second, message)
}

public fun <First, Second> Pair<First, Second>.assertByEquals(
    expected: Map.Entry<First, Second>,
    message: String = "Expected $expected to equal $this by equals, but was not"
) {
    expected.key.assertByEquals(first, message)
    expected.value.assertByEquals(second, message)
}

public fun <First, Second> Pair<First, Second>.assertByEquals(
    expectedFirst: First,
    expectedSecond: Second,
    message: String = "Expected ($expectedFirst, $expectedSecond) to equal $this by equals, but was not"
) {
    expectedFirst.assertByEquals(first, message)
    expectedSecond.assertByEquals(second, message)
}