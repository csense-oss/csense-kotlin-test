package csense.kotlin.tests.assertions.csense.kotlin.tests.assertions

import csense.kotlin.tests.assertions.*
import kotlin.test.Test

class TestNumbers {

    @Test
    fun ints() {
        22.assert(22)
        val x: Int? = null
        x.assertNull()
        @Suppress("RedundantNullableReturnType")
        val y: Int? = 42
        y.assertNotNullAndEquals(42)
        55.assertNot(42)
        44.assertIs<Int>()
        44.assertAs(44)
        44.assertLargerOrEqualTo(44)
        44.assertLargerOrEqualTo(22)

    }

}