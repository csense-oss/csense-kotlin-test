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
}