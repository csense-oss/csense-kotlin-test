package csense.kotlin.tests.assertions

import kotlin.test.Test

class NumberTest {
    @Test
    fun doubleAssertValue() {
        2.0.assert(2.0)
        2.0.assert(2.5, delta = 1.0)
        2.0.assert(2.9, delta = 1.0)
        2.0.assert(1.2, delta = 1.0)
    }

    @Test
    fun doubleAssertNotValue() {
        2.0.assertNot(3.0, delta = 0.1)
        2.0.assertNot(3.0, delta = 0.8)
        2.0.assertNot(4.0)
    }
}