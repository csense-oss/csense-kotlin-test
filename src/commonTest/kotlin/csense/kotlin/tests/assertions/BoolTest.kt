package csense.kotlin.tests.assertions

import kotlin.test.Test

class BoolTest {
    @Test
    fun booleanAssert() {
        true.assert(true)
        false.assert(false)
    }

    @Test
    fun booleanAssertFalse() {
        false.assertFalse()
    }

    @Test
    fun booleanAssertTrue() {
        true.assertTrue()
    }
}