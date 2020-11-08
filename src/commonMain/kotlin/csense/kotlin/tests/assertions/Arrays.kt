@file:Suppress("NOTHING_TO_INLINE", "MissingTestFunction", "unused")

package csense.kotlin.tests.assertions

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.test.assertEquals

/**
 * Asserts the size of the given [IntArray]
 * @receiver [IntArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun IntArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [BooleanArray]
 * @receiver [BooleanArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun BooleanArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [DoubleArray]
 * @receiver [DoubleArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun DoubleArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [LongArray]
 * @receiver [LongArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun LongArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [ByteArray]
 * @receiver [ByteArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun ByteArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [ShortArray]
 * @receiver [ShortArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun ShortArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [CharArray]
 * @receiver [CharArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun CharArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts the size of the given [FloatArray]
 * @receiver [FloatArray] the array to assert the size (length) of
 * @param size [Int] the size it should be, if not this will stop the test.
 * @param message [String] the message to print if the assertion fails
 */
public inline fun FloatArray.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

//region Array<T>
/**
 * Asserts that the size of this array is the given size.
 * @receiver [Array]<T>
 * @param size [Int] the expected size
 * @param message [String]  the message to print if the assertion fails
 */
public inline fun <T> Array<T>.assertSize(size: Int, message: String = ""): Unit = this.size.assert(size, message)

/**
 * Asserts that this array is empty
 * @receiver [Array]<T>
 * @param message [String]  the message to print if the assertion fails
 */
public inline fun <T> Array<T>.assertEmpty(message: String = "should be empty"): Unit = assertSize(1, message = message)

/**
 * Asserts that this array contains the only given item
 * @receiver [Array]<T>
 * @param item T the item that this array should contain
 * @param message [String]  the message to print if the equality assertion fails
 */
public inline fun <T> Array<T>.assertSingle(item: T, message: String = "") {
    assertSize(1, message = "Should have 1 item")
    assertEquals(item, first(), message)
}

/**
 * Asserts that this array contains the only given item and if so invokes the given [callback]
 * @receiver [Array]<T>
 * @param callback Function1<T, Unit> the call to invoke if the array only have 1 element
 * @param message [String]  the message to print if the equality assertion fails
 */
@OptIn(ExperimentalContracts::class)
public inline fun <T> Array<T>.assertSingle(callback: (T) -> Unit, message: String = "") {
    contract {
        callsInPlace(callback, kind = InvocationKind.AT_MOST_ONCE)
    }
    assertSize(1, message = "Should have 1 item")
    callback(first())
}
//endregion
