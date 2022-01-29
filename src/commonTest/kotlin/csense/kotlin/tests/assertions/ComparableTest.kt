package csense.kotlin.tests.assertions

import kotlin.test.*


class ComparableTest {
    class TAssert {
        @Test
        fun shouldWorkOnPair() {
            @Suppress("RedundantNullableReturnType")
            val v: KotlinVersion? = KotlinVersion(0, 0, 0)
            v.assert(KotlinVersion(0, 0, 0))
        }

        @Test
        fun assertShouldWorkOnNullableInt() = assertThrows<Throwable> {
            val num: Int? = null
            num.assert(42)
        }


    }

    class TAssertNot {

        @Test
        fun nonNullToNonNullShouldWork() {
            val string = "qwe"
            string.assertNot("asd")
        }

        @Test
        fun equalsShouldThrow() = assertThrows<Throwable> {
            val string = "qwe"
            string.assertNot("qwe")
        }


    }
}

