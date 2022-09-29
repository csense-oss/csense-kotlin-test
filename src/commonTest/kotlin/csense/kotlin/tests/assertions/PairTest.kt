package csense.kotlin.tests.assertions

import kotlin.test.*

class PairTest {
    class PairFirstSecondAssert {

        @Test
        fun nonNullShouldWork() {
            val p1 = Pair("a", "1")
            p1.assertByEquals("a" to "1")
        }

        @Test
        fun nullToNonNullShouldThrow() = assertThrows<Throwable> {
            val p1: Pair<String, String>? = null
            p1.assertByEquals("a" to "1")
        }
    }
}