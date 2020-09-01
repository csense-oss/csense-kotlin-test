@file:Suppress("NOTHING_TO_INLINE", "MissingTestFunction", "unused")

package csense.kotlin.tests.assertions

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