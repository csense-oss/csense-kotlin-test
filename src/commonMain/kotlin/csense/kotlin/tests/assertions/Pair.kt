package csense.kotlin.tests.assertions

public fun <First, Second> Pair<First, Second>?.assertByEquals(expected: Pair<First, Second>) {
    if (this == null) {
        failTest("Expected $expected but got $this")
    }
    expected.first.assertByEquals(first)
    expected.second.assertByEquals(second)
}
