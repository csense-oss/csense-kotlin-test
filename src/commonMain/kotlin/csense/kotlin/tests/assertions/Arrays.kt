@file:Suppress("unused")

package csense.kotlin.tests.assertions

import csense.kotlin.annotations.numbers.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.experimental.ExperimentalTypeInference
import kotlin.test.assertEquals

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

//region Array<T>
/**
 * Asserts that the size of this array is the given size.
 * @receiver [Array]<T>
 * @param size [Int] the expected size
 * @param message [String]  the message to print if the assertion fails
 */
public fun <T> Array<T>.assertSize(@IntLimit(from = 0) size: Int, message: String = ""): Unit =
    this.size.assert(size, message)

/**
 * Asserts that this array is empty
 * @receiver [Array]<T>
 * @param message [String] the message to print if the assertion fails
 */
public fun <T> Array<T>.assertEmpty(message: String = "should be empty"): Unit = assertSize(0, message = message)

/**
 * Asserts that this array has content
 * @param message String the assertion message if the array is empty
 */
public fun <T> Array<T>.assertNotEmpty(message: String = "should have content"): Unit =
    size.assertLargerOrEqualTo(1, optMessage = message)


//region specific array type: assertEmpty
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

//region specific array type: assertSingle
/**
 * Asserts that this array contains the only given item
 * @param item Int the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun IntArray.assertSingle(item: Int, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Boolean the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun BooleanArray.assertSingle(item: Boolean, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Double the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun DoubleArray.assertSingle(item: Double, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Long the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun LongArray.assertSingle(item: Long, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Float the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun FloatArray.assertSingle(item: Float, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Short the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun ShortArray.assertSingle(item: Short, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item
 * @param item Char the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun CharArray.assertSingle(item: Char, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}
//endregion

/**
 * Asserts that this array contains the only given item
 * @receiver [Array]<T>
 * @param item T the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public fun <T> Array<T>.assertSingle(item: T, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item and if so invokes the given [callback]
 * @receiver [Array]<T>
 * @param message [String]  the message to print if the equality assertion fails
 * @param callback Function1<T, Unit> the call to invoke if the array only have 1 element
 */
@OptIn(ExperimentalContracts::class, ExperimentalTypeInference::class)
public fun <T> Array<T>.assertSingle(message: String = "Should have 1 item", callback: (T) -> Unit) {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1, message = message)
    callback(first())
}
//endregion
