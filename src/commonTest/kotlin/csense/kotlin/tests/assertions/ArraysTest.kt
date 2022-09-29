@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlin.test.Test

class ArraysTest {
    //region assertSize
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

    //endregion

    //region assertEmpty
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

    class IntArrayAssertEmptyMessage {
        @Test
        fun empty() {
            intArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            intArrayOf(42).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            intArrayOf(11, 42).assertEmpty()
        }
    }

    class BooleanArrayAssertEmptyMessage {
        @Test
        fun empty() {
            booleanArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            booleanArrayOf(true).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            booleanArrayOf(false, true).assertEmpty()
        }
    }


    class DoubleArrayAssertEmptyMessage {
        @Test
        fun empty() {
            doubleArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            doubleArrayOf(1.0).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            doubleArrayOf(1.0, 2.0).assertEmpty()
        }
    }


    class LongArrayAssertEmptyMessage {
        @Test
        fun empty() {
            longArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            longArrayOf(1).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            longArrayOf(1, 2).assertEmpty()
        }
    }

    class FloatArrayAssertEmptyMessage {
        @Test
        fun empty() {
            floatArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            floatArrayOf(1f).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            floatArrayOf(1f, 2f).assertEmpty()
        }
    }


    class ShortArrayAssertEmptyMessage {
        @Test
        fun empty() {
            shortArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            shortArrayOf(1).assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            shortArrayOf(1, 2).assertEmpty()
        }
    }

    class CharArrayAssertEmptyMessage {
        @Test
        fun empty() {
            charArrayOf().assertEmpty()
        }

        @Test
        fun throwsOnNonEmpty() = assertThrows<Throwable> {
            charArrayOf('1').assertEmpty()
        }

        @Test
        fun throwsOnMultiple() = assertThrows<Throwable> {
            charArrayOf('1', '2').assertEmpty()
        }
    }

//endregion

    //region assertNotEmpty

    class ArrayTAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            arrayOf<String>().assertNotEmpty()
        }


        @Test
        fun single() {
            arrayOf("test").assertNotEmpty()
        }


        @Test
        fun multiple() {
            arrayOf("test", "1234").assertNotEmpty()
        }
    }

    class IntArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            intArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            intArrayOf(1).assertNotEmpty()
        }


        @Test
        fun multiple() {
            intArrayOf(1, 2).assertNotEmpty()
        }
    }

    class LongArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            longArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            longArrayOf(1).assertNotEmpty()
        }


        @Test
        fun multiple() {
            longArrayOf(1, 2).assertNotEmpty()
        }
    }

    class ShortArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            shortArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            shortArrayOf(1).assertNotEmpty()
        }


        @Test
        fun multiple() {
            shortArrayOf(1, 2).assertNotEmpty()
        }
    }

    class BooleanArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            booleanArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            booleanArrayOf(true).assertNotEmpty()
        }


        @Test
        fun multiple() {
            booleanArrayOf(false, true).assertNotEmpty()
        }
    }

    class CharArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            charArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            charArrayOf('a').assertNotEmpty()
        }


        @Test
        fun multiple() {
            charArrayOf('a', 'b').assertNotEmpty()
        }
    }


    class FloatArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            floatArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            floatArrayOf(1f).assertNotEmpty()
        }


        @Test
        fun multiple() {
            floatArrayOf(1f, 2f).assertNotEmpty()
        }
    }


    class DoubleArrayAssertNotEmptyMessage {

        @Test
        fun empty() = assertThrows<Throwable> {
            doubleArrayOf().assertNotEmpty()
        }


        @Test
        fun single() {
            doubleArrayOf(1.0).assertNotEmpty()
        }


        @Test
        fun multiple() {
            doubleArrayOf(1.0, 2.0).assertNotEmpty()
        }
    }

    //endregion

    //region assertSingle
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

    class CharArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            charArrayOf().assertSingle('a')
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            charArrayOf('b').assertSingle('a')
        }

        @Test
        fun singleSame() {
            charArrayOf('a').assertSingle('a')
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            charArrayOf('a', 'b').assertSingle('a')
        }
    }

    class ShortArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            shortArrayOf().assertSingle(1)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            shortArrayOf(2).assertSingle(1)
        }

        @Test
        fun singleSame() {
            shortArrayOf(1).assertSingle(1)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            shortArrayOf(1, 2).assertSingle(1)
        }
    }


    class FloatArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            floatArrayOf().assertSingle(1f)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            floatArrayOf(2f).assertSingle(1f)
        }

        @Test
        fun singleSame() {
            floatArrayOf(1f).assertSingle(1f)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            floatArrayOf(1f, 2f).assertSingle(1f)
        }
    }

    class LongArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            longArrayOf().assertSingle(1)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            longArrayOf(2).assertSingle(1)
        }

        @Test
        fun singleSame() {
            longArrayOf(1).assertSingle(1)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            longArrayOf(1, 2).assertSingle(1)
        }
    }

    class DoubleArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            doubleArrayOf().assertSingle(1.0)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            doubleArrayOf(2.0).assertSingle(1.0)
        }

        @Test
        fun singleSame() {
            doubleArrayOf(1.0).assertSingle(1.0)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            doubleArrayOf(1.0, 2.0).assertSingle(1.0)
        }
    }

    class BooleanArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            booleanArrayOf().assertSingle(true)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            booleanArrayOf(false).assertSingle(true)
        }

        @Test
        fun singleSame() {
            booleanArrayOf(true).assertSingle(true)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            booleanArrayOf(true, false).assertSingle(true)
        }
    }


    class IntArrayAssertSingle {
        @Test
        fun empty() = assertThrows<Throwable> {
            intArrayOf().assertSingle(1)
        }

        @Test
        fun singleNotSame() = assertThrows<Throwable> {
            intArrayOf(2).assertSingle(1)
        }

        @Test
        fun singleSame() {
            intArrayOf(1).assertSingle(1)
        }

        @Test
        fun multiple() = assertThrows<Throwable> {
            intArrayOf(1, 2).assertSingle(1)
        }
    }


    //endregion

    //region assertSingle with callback

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


    //endregion

    //region assert


    class BooleanArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            booleanArrayOf().assert(booleanArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            booleanArrayOf().assert(booleanArrayOf(true))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            booleanArrayOf().assert(booleanArrayOf(true, false))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            booleanArrayOf(false).assert(booleanArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            booleanArrayOf(true).assert(booleanArrayOf(true))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            booleanArrayOf(true).assert(booleanArrayOf(false))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            booleanArrayOf(true).assert(booleanArrayOf(true, false))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            booleanArrayOf(true, false).assert(booleanArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            booleanArrayOf(true, false).assert(booleanArrayOf(true))
        }

        @Test
        fun multipleToMultipleSame() {
            booleanArrayOf(true, false).assert(booleanArrayOf(true, false))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            booleanArrayOf(true, true).assert(booleanArrayOf(true, false))
        }


    }

    class ByteArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            byteArrayOf().assert(byteArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            byteArrayOf().assert(byteArrayOf(1))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            byteArrayOf().assert(byteArrayOf(1, 2))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            byteArrayOf(2).assert(byteArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            byteArrayOf(1).assert(byteArrayOf(1))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            byteArrayOf(1).assert(byteArrayOf(2))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            byteArrayOf(1).assert(byteArrayOf(1, 2))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            byteArrayOf(1, 2).assert(byteArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            byteArrayOf(1, 2).assert(byteArrayOf(1))
        }

        @Test
        fun multipleToMultipleSame() {
            byteArrayOf(1, 2).assert(byteArrayOf(1, 2))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            byteArrayOf(1, 1).assert(byteArrayOf(1, 2))
        }
    }

    class CharArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            charArrayOf().assert(charArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            charArrayOf().assert(charArrayOf('a'))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            charArrayOf().assert(charArrayOf('a', 'b'))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            charArrayOf('b').assert(charArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            charArrayOf('a').assert(charArrayOf('a'))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            charArrayOf('a').assert(charArrayOf('b'))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            charArrayOf('a').assert(charArrayOf('a', 'b'))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            charArrayOf('a', 'b').assert(charArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            charArrayOf('a', 'b').assert(charArrayOf('a'))
        }

        @Test
        fun multipleToMultipleSame() {
            charArrayOf('a', 'b').assert(charArrayOf('a', 'b'))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            charArrayOf('a', 'a').assert(charArrayOf('a', 'b'))
        }
    }


    class DoubleArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            doubleArrayOf().assert(doubleArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            doubleArrayOf().assert(doubleArrayOf(1.0))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            doubleArrayOf().assert(doubleArrayOf(1.0, 2.0))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            doubleArrayOf(2.0).assert(doubleArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            doubleArrayOf(1.0).assert(doubleArrayOf(1.0))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            doubleArrayOf(1.0).assert(doubleArrayOf(2.0))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            doubleArrayOf(1.0).assert(doubleArrayOf(1.0, 2.0))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            doubleArrayOf(1.0, 2.0).assert(doubleArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            doubleArrayOf(1.0, 2.0).assert(doubleArrayOf(1.0))
        }

        @Test
        fun multipleToMultipleSame() {
            doubleArrayOf(1.0, 2.0).assert(doubleArrayOf(1.0, 2.0))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            doubleArrayOf(1.0, 1.0).assert(doubleArrayOf(1.0, 2.0))
        }
    }

    class FloatArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            floatArrayOf().assert(floatArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            floatArrayOf().assert(floatArrayOf(1f))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            floatArrayOf().assert(floatArrayOf(1f, 2f))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            floatArrayOf(2f).assert(floatArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            floatArrayOf(1f).assert(floatArrayOf(1f))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            floatArrayOf(1f).assert(floatArrayOf(2f))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            floatArrayOf(1f).assert(floatArrayOf(1f, 2f))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            floatArrayOf(1f, 2f).assert(floatArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            floatArrayOf(1f, 2f).assert(floatArrayOf(1f))
        }

        @Test
        fun multipleToMultipleSame() {
            floatArrayOf(1f, 2f).assert(floatArrayOf(1f, 2f))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            floatArrayOf(1f, 1f).assert(floatArrayOf(1f, 2f))
        }
    }


    class IntArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            intArrayOf().assert(intArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            intArrayOf().assert(intArrayOf(1))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            intArrayOf().assert(intArrayOf(1, 2))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            intArrayOf(2).assert(intArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            intArrayOf(1).assert(intArrayOf(1))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            intArrayOf(1).assert(intArrayOf(2))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            intArrayOf(1).assert(intArrayOf(1, 2))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            intArrayOf(1, 2).assert(intArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            intArrayOf(1, 2).assert(intArrayOf(1))
        }

        @Test
        fun multipleToMultipleSame() {
            intArrayOf(1, 2).assert(intArrayOf(1, 2))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            intArrayOf(1, 1).assert(intArrayOf(1, 2))
        }
    }


    class LongArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            longArrayOf().assert(longArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            longArrayOf().assert(longArrayOf(1))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            longArrayOf().assert(longArrayOf(1, 2))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            longArrayOf(2).assert(longArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            longArrayOf(1).assert(longArrayOf(1))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            longArrayOf(1).assert(longArrayOf(2))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            longArrayOf(1).assert(longArrayOf(1, 2))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            longArrayOf(1, 2).assert(longArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            longArrayOf(1, 2).assert(longArrayOf(1))
        }

        @Test
        fun multipleToMultipleSame() {
            longArrayOf(1, 2).assert(longArrayOf(1, 2))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            longArrayOf(1, 1).assert(longArrayOf(1, 2))
        }
    }

    class ShortArrayAssertExpected {

        @Test
        fun emptyToEmpty() {
            shortArrayOf().assert(shortArrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            shortArrayOf().assert(shortArrayOf(1))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            shortArrayOf().assert(shortArrayOf(1, 2))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            shortArrayOf(2).assert(shortArrayOf())
        }

        @Test
        fun singleToSingleSame() {
            shortArrayOf(1).assert(shortArrayOf(1))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            shortArrayOf(1).assert(shortArrayOf(2))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            shortArrayOf(1).assert(shortArrayOf(1, 2))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            shortArrayOf(1, 2).assert(shortArrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            shortArrayOf(1, 2).assert(shortArrayOf(1))
        }

        @Test
        fun multipleToMultipleSame() {
            shortArrayOf(1, 2).assert(shortArrayOf(1, 2))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            shortArrayOf(1, 1).assert(shortArrayOf(1, 2))
        }
    }


    class ArrayOutTAssertExpected {

        @Test
        fun emptyToEmpty() {
            arrayOf<String>().assert(arrayOf())
        }

        @Test
        fun emptyToSingle() = assertThrows<Throwable> {
            arrayOf<String>().assert(arrayOf("1"))
        }

        @Test
        fun emptyToMultiple() = assertThrows<Throwable> {
            arrayOf<String>().assert(arrayOf("1", "2"))
        }

        @Test
        fun singleToEmpty() = assertThrows<Throwable> {
            arrayOf("2").assert(arrayOf())
        }

        @Test
        fun singleToSingleSame() {
            arrayOf("1").assert(arrayOf("1"))
        }

        @Test
        fun singleToSingleDifferent() = assertThrows<Throwable> {
            arrayOf("1").assert(arrayOf("2"))
        }

        @Test
        fun singleToMultiple() = assertThrows<Throwable> {
            arrayOf("1").assert(arrayOf("1", "2"))
        }

        @Test
        fun multipleToEmpty() = assertThrows<Throwable> {
            arrayOf("1", "2").assert(arrayOf())
        }

        @Test
        fun multipleToSingle() = assertThrows<Throwable> {
            arrayOf("1", "2").assert(arrayOf("1"))
        }

        @Test
        fun multipleToMultipleSame() {
            arrayOf("1", "2").assert(arrayOf("1", "2"))
        }

        @Test
        fun multipleToMultipleDifferent() = assertThrows<Throwable> {
            arrayOf("1", "1").assert(arrayOf("1", "2"))
        }

    }


    //endregion
}
