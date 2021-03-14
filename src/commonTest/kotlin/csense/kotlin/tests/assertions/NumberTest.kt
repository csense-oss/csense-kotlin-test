package csense.kotlin.tests.assertions

import kotlin.test.Test

class NumberTest {
    @Test
    fun doubleAssertValue() {
        2.0.assert(2.0)
        2.0.assert(2.5, delta = 1.0)
        2.0.assert(2.9, delta = 1.0)
        2.0.assert(1.2, delta = 1.0)
        assertThrows<Throwable> {
            2.0.assert(3.0)
        }
        assertThrows<Throwable> {
            2.0.assert(3.0)
        }
    }

    @Test
    fun doubleAssertNotValue() {
        2.0.assertNot(3.0, delta = 0.1)
        2.0.assertNot(3.0, delta = 0.8)
        2.0.assertNot(4.0)
    }

    @Test
    fun floatAssertValue() {
        2.0f.assert(2.0f)
        2.0f.assert(2.5f, delta = 1.0f)
        2.0f.assert(2.9f, delta = 1.0f)
        2.0f.assert(1.2f, delta = 1.0f)
    }

    @Test
    fun floatAssertNotValue() {
        2.0f.assertNot(3.0f, delta = 0.1f)
        2.0f.assertNot(3.0f, delta = 0.8f)
        2.0f.assertNot(4.0f)
    }

    @Test
    fun charAssertValue() {
        'a'.assert('a')
        assertThrows<Throwable> {
            'a'.assert('b')
        }
        assertThrows<Throwable> {
            'b'.assert('a')
        }
        assertThrows<Throwable> {
            'a'.assert('A', ignoreCase = false)
        }
        'a'.assert('A', ignoreCase = true)
    }

    @Test
    fun charAssertNotValue() {
        'a'.assertNot('b')
        assertThrows<Throwable> {
            'a'.assertNot('a')
        }
        'b'.assertNot('a')
        assertThrows<Throwable> {
            'a'.assertNot('A', ignoreCase = true)
        }
        'a'.assertNot('A', ignoreCase = false)
    }
}