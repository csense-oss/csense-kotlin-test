package csense.kotlin.tests.assertions

import kotlin.test.Test

class GeneralTest {
    @Test
    fun testShouldNotBeCalled() {
        assertThrows<Throwable> {
            shouldNotBeCalled()
        }
    }

    @Test
    fun failTest() {
        assertThrows<Throwable> {
            failTest("")
        }
    }

    @Test
    fun anyAssertNotNull() {
        "".assertNotNull()
        assertThrows<Throwable> {
            val x: Int? = null
            x.assertNotNull()
        }
    }

    @Test
    fun anyAssertNull() {
        val x: Int? = null
        x.assertNull()
        assertThrows<Throwable> {
            "".assertNull()
        }
    }


    class AssertCallbackCalledWithExpectedItemsInOrder {
        @Test
        fun empty() {
            assertCallbackCalledWith(listOf<String>()) {

            }
        }

        @Test
        fun singleNotCalledFails() = assertThrows<Throwable> {
            assertCallbackCalledWith(listOf("test")) {

            }
        }

        @Test
        fun singleMatchingDoesNotThrow() {
            assertCallbackCalledWith(listOf("test")) {
                it("test")
            }
        }

        @Test
        fun singleDifferentDoesThrow() = assertThrows<Throwable> {
            assertCallbackCalledWith(listOf("test")) {
                it("1234")
            }
        }

        @Test
        fun multipleDifferentDoesThrow() = assertThrows<Throwable> {
            assertCallbackCalledWith(listOf("test", "1234")) {
                it("test")
                it("abc")
            }
        }

        @Test
        fun multipleMatchingDoesNotThrow() {
            assertCallbackCalledWith(listOf("test2", "1234")) {
                it("test2")
                it("1234")
            }
        }

    }

    @Test
    fun assertCallbackCalledWithComparable() {


    }

    class TAssertByEquals {

        @Test
        fun usingAnyEqualsWhenNoEqualsIsPresent() {
            val first = IAmRaw("a")
            val second = IAmRaw("b")
            val firstCopy = IAmRaw("a")
            assertThrows<Throwable> {
                first.assertByEquals(second)
            }
            assertThrows<Throwable>("Any uses reference not equality") {
                first.assertByEquals(firstCopy)
            }
            //cases for reference(s)
            first.assertByEquals(first)
            second.assertByEquals(second)
            firstCopy.assertByEquals(firstCopy)
        }

        @Test
        fun usingRegularEqualsImplemented() {
            val first = ILikeEquals("a")
            val second = ILikeEquals("b")
            val third = ILikeEquals("a")

            first.assertByEquals(first)
            assertThrows<Throwable> {
                first.assertByEquals(second)
            }
            first.assertByEquals(third)

            first.equalsCounter.assert(3)


            assertThrows<Throwable> {
                second.assertByEquals(first)
            }
            second.assertByEquals(second)
            assertThrows<Throwable> {
                second.assertByEquals(third)
            }
            second.equalsCounter.assert(3)

            third.assertByEquals(first)
            assertThrows<Throwable> {
                third.assertByEquals(second)
            }
            third.assertByEquals(third)
            third.equalsCounter.assert(3)
        }

        private class IAmRaw(
            val id: String
        )

        private class ILikeEquals(
            val id: String
        ) {
            var equalsCounter = 0
            override fun equals(other: Any?): Boolean {
                equalsCounter += 1
                if (this === other) return true
                if (other == null || this::class != other::class) return false

                other as ILikeEquals

                if (id != other.id) return false

                return true
            }

            override fun hashCode(): Int {
                return id.hashCode()
            }
        }
    }
}