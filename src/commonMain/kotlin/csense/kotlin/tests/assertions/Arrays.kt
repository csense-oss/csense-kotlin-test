@file:Suppress("unused")

package csense.kotlin.tests.assertions

import csense.kotlin.annotations.numbers.*
import kotlin.contracts.*
import kotlin.test.*

//region assertSize
/**
 * Asserts the size of the given [IntArray]
 * @receiver [IntArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun IntArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [BooleanArray]
 * @receiver [BooleanArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun BooleanArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [DoubleArray]
 * @receiver [DoubleArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun DoubleArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [LongArray]
 * @receiver [LongArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun LongArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [ByteArray]
 * @receiver [ByteArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun ByteArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [ShortArray]
 * @receiver [ShortArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun ShortArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [CharArray]
 * @receiver [CharArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun CharArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts the size of the given [FloatArray]
 * @receiver [FloatArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public fun FloatArray.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts that the size of this array is the given size.
 * @receiver [Array]<T>
 * @param size [Int] the expected size
 * @param message [String]  the message to print if the assertion fails
 */
public fun <T> Array<T>.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

//endregion

//region assertEmpty
/**
 * Asserts that this array is empty
 * @receiver [Array]<T>
 * @param message [String] the message to print if the assertion fails
 */
public fun <T> Array<T>.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun IntArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun BooleanArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun DoubleArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun LongArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun FloatArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun ShortArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array is empty
 * @param message [String] the message to print if the assertion fails
 */
public fun CharArray.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)
//endregion

//region assertNotEmpty
/**
 * Asserts that this array has content
 * @param message String the assertion message if the array is empty
 */
public fun <T> Array<T>.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)


/**
 * Asserts that this IntArray has content
 * @param message String the assertion message if the array is empty
 */
public fun IntArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)


/**
 * Asserts that this LongArray has content
 * @param message String the assertion message if the array is empty
 */
public fun LongArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)

/**
 * Asserts that this ShortArray has content
 * @param message String the assertion message if the array is empty
 */
public fun ShortArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)

/**
 * Asserts that this BooleanArray has content
 * @param message String the assertion message if the array is empty
 */
public fun BooleanArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)

/**
 * Asserts that this CharArray has content
 * @param message String the assertion message if the array is empty
 */
public fun CharArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)


/**
 * Asserts that this FloatArray has content
 * @param message String the assertion message if the array is empty
 */
public fun FloatArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)


/**
 * Asserts that this DoubleArray has content
 * @param message String the assertion message if the array is empty
 */
public fun DoubleArray.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)

//endregion

//region assertSingle
/**
 * Asserts that this array contains the only given item
 * @param item Int the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun IntArray?.assertSingle(item: Int, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Boolean the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun BooleanArray?.assertSingle(item: Boolean, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Double the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun DoubleArray?.assertSingle(item: Double, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Long the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun LongArray?.assertSingle(item: Long, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Float the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun FloatArray?.assertSingle(item: Float, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Short the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun ShortArray?.assertSingle(item: Short, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Char the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun CharArray?.assertSingle(item: Char, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @receiver [Array]<T>
 * @param item T the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun <T> Array<T>?.assertSingle(item: T, message: String = "") {
    assertNotNull()
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

//endregion

//region assertSingle with callback

/**
 * Asserts that this array contains the only given item and if so invokes the given [callback]
 * @receiver [Array]<T>
 * @param message [String]  the message to print if the equality assertion fails
 * @param callback Function1<T, Unit> the call to invoke if the array only have 1 element
 */
public fun <T> Array<T>?.assertSingle(message: String = "Should have 1 item", callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, InvocationKind.AT_MOST_ONCE)
    }
    assertNotNull()
    assertSize(size = 1, message = message)
    callback(first())
}


//TODO add assertSingle for all specific array types.

//endregion

//region assert

public fun BooleanArray.assert(
    expected: BooleanArray,
    message: String = "Expected this BooleanArray to be the same as expected but was different"
) {

    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = BooleanArray::size,
        getElementAt = BooleanArray::get
    )
}

public fun ByteArray.assert(
    expected: ByteArray,
    message: String = "Expected this ByteArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = ByteArray::size,
        getElementAt = ByteArray::get
    )
}

public fun CharArray.assert(
    expected: CharArray,
    message: String = "Expected this CharArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = CharArray::size,
        getElementAt = CharArray::get
    )
}

public fun DoubleArray.assert(
    expected: DoubleArray,
    message: String = "Expected this DoubleArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = DoubleArray::size,
        getElementAt = DoubleArray::get
    )
}


public fun FloatArray.assert(
    expected: FloatArray,
    message: String = "Expected this FloatArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = FloatArray::size,
        getElementAt = FloatArray::get
    )
}

public fun IntArray.assert(
    expected: IntArray,
    message: String = "Expected this IntArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = IntArray::size,
        getElementAt = IntArray::get
    )
}

public fun LongArray.assert(
    expected: LongArray,
    message: String = "Expected this LongArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = LongArray::size,
        getElementAt = LongArray::get
    )
}

public fun ShortArray.assert(
    expected: ShortArray,
    message: String = "Expected this ShortArray to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = ShortArray::size,
        getElementAt = ShortArray::get
    )
}

public fun <T : Comparable<T>> Array<out T>.assert(
    expected: Array<out T>,
    message: String = "Expected this Array to be the same as expected but was different"
) {
    ArrayAssertions.AssertArrays(
        givenArray = this,
        expected = expected,
        message = message,
        getSize = { size },
        getElementAt = { get(it) }
    )
}

public object ArrayAssertions {
    public fun <T, U : Comparable<U>> AssertArrays(
        givenArray: T,
        expected: T,
        message: String,
        getSize: T.() -> Int,
        getElementAt: T.(index: Int) -> U
    ) {
        val givenSize = givenArray.getSize()
        val expectedSize = expected.getSize()
        givenSize.assert(
            expectedSize,
            message = "Expected this to have same number($givenSize of elements as the expected ($expectedSize)"
        )
        for (index in 0 until givenSize) {
            val thisItem = givenArray.getElementAt(index)
            val expectedItem = expected.getElementAt(index)

            thisItem.assert(
                expected = expectedItem,
                message = "$message.Failed at index $index, with byte: $thisItem, expected $expectedItem"
            )
        }
    }
}
//endregion
