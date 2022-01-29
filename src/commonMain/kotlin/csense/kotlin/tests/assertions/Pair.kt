package csense.kotlin.tests.assertions

import kotlin.test.*

public fun <First, Second> Pair<First, Second>?.assert(expected: Pair<First, Second>) {
    if (this == null) {
        failTest("Expected $expected but got $this")
    }
    assertEquals(expected.first, this.first)
    assertEquals(expected.second, this.second)
}
