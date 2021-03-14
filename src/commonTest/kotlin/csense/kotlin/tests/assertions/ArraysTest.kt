@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlin.test.Test

class ArraysTest {
    class IntArrayAssertSizeSize {
        @Test
        fun empty() {
            intArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            intArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            intArrayOf(22).assertSize(1)
        }

        @Test
        fun multiple() {
            intArrayOf(22, 22).assertSize(2)
        }
    }

    class BooleanArrayAssertSizeSize {
        @Test
        fun empty() {
            booleanArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            booleanArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            booleanArrayOf(false).assertSize(1)
        }

        @Test
        fun multiple() {
            booleanArrayOf(false, true).assertSize(2)
        }

    }

    class DoubleArrayAssertSizeSize {
        @Test
        fun empty() {
            doubleArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            doubleArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            doubleArrayOf(0.5).assertSize(1)
        }

        @Test
        fun multiple() {
            doubleArrayOf(1.0, 2.54).assertSize(2)
        }

    }


    class LongArrayAssertSizeSize {
        @Test
        fun empty() {
            longArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            longArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            longArrayOf(5).assertSize(1)
        }

        @Test
        fun multiple() {
            longArrayOf(1, 2).assertSize(2)
        }
    }

    class ByteArrayAssertSizeSize {
        @Test
        fun empty() {
            byteArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            byteArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            byteArrayOf(5).assertSize(1)
        }

        @Test
        fun multiple() {
            byteArrayOf(1, 2).assertSize(2)
        }
    }

    class ShortArrayAssertSizeSize {
        @Test
        fun empty() {
            shortArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            shortArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            shortArrayOf(5).assertSize(1)
        }

        @Test
        fun multiple() {
            shortArrayOf(1, 2).assertSize(2)
        }
    }


    class CharArrayAssertSizeSize {
        @Test
        fun empty() {
            charArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            charArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            charArrayOf('5').assertSize(1)
        }

        @Test
        fun multiple() {
            charArrayOf('1', '2').assertSize(2)
        }
    }

    class FloatArrayAssertSizeSize {
        @Test
        fun empty() {
            floatArrayOf().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            floatArrayOf().assertSize(1)
        }


        @Test
        fun single() {
            floatArrayOf(3f).assertSize(1)
        }

        @Test
        fun multiple() {
            floatArrayOf(1f, 2.1f).assertSize(2)
        }
    }

    class ArrayTAssertSizeSize {
        @Test
        fun empty() {
            arrayOf<String>().assertSize(0)
        }

        @Test
        fun throwsOnWrongSize() = assertThrows<Throwable> {
            arrayOf<String>().assertSize(1)
        }


        @Test
        fun single() {
            arrayOf("test").assertSize(1)
        }

        @Test
        fun multiple() {
            arrayOf("first", "second").assertSize(2)
        }
    }

    class ArrayTAssertEmpty {
        @Test
        fun empty() {
            arrayOf<String>().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            arrayOf("test").assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            arrayOf("first", "second").assertEmpty()
        }
    }

    class ArrayTAssertSingleItem {
        @Test
        fun empty() = assertThrows<Throwable> {
            arrayOf<String>().assertSingle("test")
        }

        @Test
        fun single() {
            arrayOf("test").assertSingle("test")
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            arrayOf("a", "b").assertSingle("a")
        }
    }

    class ArrayTAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            arrayOf<String>().assertSingle {
                shouldNotBeCalled()
            }
        }

        @Test
        fun single() = assertCalled { shouldBeCalled ->
            arrayOf("asd").assertSingle {
                it.assert("asd")
                shouldBeCalled()
            }
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            arrayOf("a", "b").assertSingle {
                shouldNotBeCalled()
            }
        }
    }
}


