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


    class AssertCallbackCalledWithExpectedItemsInOrder() {
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
}