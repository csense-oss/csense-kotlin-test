package csense.kotlin.tests.assertions

import kotlin.test.*

public fun <First, Second> Pair<First, Second>?.assert(other: Pair<First, Second>) {
    if (this == null) {
        failTest("Expected $other but got $this")
    }
    assertEquals(other.first, this.first)
    assertEquals(other.second, this.second)
}
