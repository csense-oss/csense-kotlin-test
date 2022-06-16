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

        Double.NaN.assert(Double.NaN)

        assertThrows<Throwable> {
            Double.NaN.assert(3.0)
        }

        assertThrows<Throwable> {
            3.0.assert(Double.NaN)
        }

        Double.POSITIVE_INFINITY.assert(Double.POSITIVE_INFINITY)
        Double.NEGATIVE_INFINITY.assert(Double.NEGATIVE_INFINITY)

        assertThrows<Throwable> {
            Double.POSITIVE_INFINITY.assert(Double.NEGATIVE_INFINITY)
        }

        assertThrows<Throwable> {
            3.0.assert(Double.NEGATIVE_INFINITY)
        }

        assertThrows<Throwable> {
            3.0.assert(Double.POSITIVE_INFINITY)
        }


        assertThrows<Throwable> {
            Double.NEGATIVE_INFINITY.assert(3.0)
        }

        assertThrows<Throwable> {
            Double.POSITIVE_INFINITY.assert(3.0)
        }

    }

    @Test
    fun doubleAssertNotValue() {
        2.0.assertNot(3.0, delta = 0.1)
        2.0.assertNot(3.0, delta = 0.8)
        2.0.assertNot(4.0)

        assertThrows<Throwable> {
            Double.NaN.assertNot(Double.NaN)
        }

//        Double.NaN.assertNot(3.0)

//        3.0.assertNot(Double.NaN)
//
//
//        assertThrows<Throwable> {
//            Double.POSITIVE_INFINITY.assertNot(Double.POSITIVE_INFINITY)
//        }
//        assertThrows<Throwable> {
//            Double.NEGATIVE_INFINITY.assertNot(Double.NEGATIVE_INFINITY)
//        }
//
//        Double.POSITIVE_INFINITY.assertNot(Double.NEGATIVE_INFINITY)
//        3.0.assertNot(Double.NEGATIVE_INFINITY)
//        3.0.assertNot(Double.POSITIVE_INFINITY)
//        Double.NEGATIVE_INFINITY.assertNot(3.0)
//        Double.POSITIVE_INFINITY.assertNot(3.0)
    }

    @Test
    fun floatAssertValue() {

        2.0f.assert(2.0f)
        2.0f.assert(2.5f, delta = 1.0f)
        2.0f.assert(2.9f, delta = 1.0f)
        2.0f.assert(1.2f, delta = 1.0f)

        Float.NaN.assert(Float.NaN)

        assertThrows<Throwable> {
            Float.NaN.assert(3f)
        }

        assertThrows<Throwable> {
            3f.assert(Float.NaN)
        }

        Float.POSITIVE_INFINITY.assert(Float.POSITIVE_INFINITY)
        Float.NEGATIVE_INFINITY.assert(Float.NEGATIVE_INFINITY)

        assertThrows<Throwable> {
            Float.POSITIVE_INFINITY.assert(Float.NEGATIVE_INFINITY)
        }

        assertThrows<Throwable> {
            3f.assert(Float.NEGATIVE_INFINITY)
        }

        assertThrows<Throwable> {
            3f.assert(Float.POSITIVE_INFINITY)
        }


        assertThrows<Throwable> {
            Float.NEGATIVE_INFINITY.assert(3f)
        }

        assertThrows<Throwable> {
            Float.POSITIVE_INFINITY.assert(3f)
        }


    }

    @Test
    fun floatAssertNotValue() {
        2.0f.assertNot(3.0f, delta = 0.1f)
        2.0f.assertNot(3.0f, delta = 0.8f)
        2.0f.assertNot(4.0f)

        assertThrows<Throwable> {
            Float.NaN.assertNot(Float.NaN)
        }
        Float.NaN.assertNot(3f)
        3f.assertNot(Float.NaN)


        assertThrows<Throwable> {
            Float.POSITIVE_INFINITY.assertNot(Float.POSITIVE_INFINITY)
        }
        assertThrows<Throwable> {
            Float.NEGATIVE_INFINITY.assertNot(Float.NEGATIVE_INFINITY)
        }

        Float.POSITIVE_INFINITY.assertNot(Float.NEGATIVE_INFINITY)
        3f.assertNot(Float.NEGATIVE_INFINITY)
        3f.assertNot(Float.POSITIVE_INFINITY)
        Float.NEGATIVE_INFINITY.assertNot(3f)
        Float.POSITIVE_INFINITY.assertNot(3f)
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