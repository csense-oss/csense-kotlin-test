@file:Suppress("NOTHING_TO_INLINE", "unused")

package csense.kotlin.tests.assertions

import kotlin.math.abs
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

//region Double
/**
 * Asserts that this [Double] is equal to the other double (given the [delta] / margin to account for imprecision)
 * @receiver [Double] the actual value
 * @param value [Double] the value we expect
 * @param delta [Double] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public inline fun Double.assert(
    value: Double,
    delta: Double = 0.1,
    message: String = "expected $value within $delta margins, but got $this"
) {
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, message)
}


/**
 *
 * @receiver Double
 * @param value Double
 * @param delta Double
 * @param message String
 */
public inline fun Double.assertNot(
    value: Double,
    delta: Double = 0.1,
    message: String = "expected $value to be different from $this within $delta margins, but they are equal"
) {
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, message)
}


//endregion

//region Float

/**
 * Asserts that this [Float] is equal to the other float (given the [delta] / margin to account for imprecision)
 * @receiver [Float] the actual value
 * @param value [Float] the value we expect
 * @param delta [Float] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public inline fun Float.assert(
    value: Float,
    delta: Float = 0.1f,
    message: String = "expected $value within $delta margins, but got $this"
) {
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, message)
}


/**
 *
 * @receiver Float
 * @param value Double
 * @param delta Double
 * @param message String
 */
public inline fun Float.assertNot(
    value: Float,
    delta: Float = 0.1F,
    message: String = "expected $value to be different from $this within $delta margins, but they are equal"
) {
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, message)
}
//endregion


//region Char
/**
 * Asserts this [Char] is the same as the given [value]
 * @receiver [Char] the actual char
 * @param value [Char] the expected char
 * @param message [String] the message to show if they differ
 */
public inline fun Char.assert(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = "Expected $value but is instead $this"
) {
    val isEqual = this.equals(value, ignoreCase)
    if (!isEqual) {
        failTest(message)
    }
}

/**
 *
 * @receiver Char
 * @param value Char
 * @param message String
 */
public inline fun Char.assertNot(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = "Expected '$this' to be different from '$value', but they are the same"
) {
    val isEqual = this.equals(value, ignoreCase)
    if (isEqual) {
        failTest(message)
    }

}
//endregion

//region Byte
/**
 * Asserts this byte is the same as the given [value]
 * @receiver [Byte] the actual value
 * @param value [Byte] the expected value
 * @param message [String] the message to show if they differ
 */
public inline fun Byte.assert(value: Byte, message: String = "Expected $value but is instead $this"): Unit =
    assertEquals(value, this, message)

public inline fun Byte.assertNot(
    value: Byte,
    message: String = "Expected $value to be different from $this but they are the same"
): Unit = assertNotEquals(value, this, message)
//endregion

//region IntRange
/**
 * Asserts this range is the same as [otherRange]
 * @receiver [IntRange] the actual range
 * @param otherRange [IntRange] the expected range
 * @param message [String] the message to show if they differ
 */
public inline fun IntRange.assert(
    otherRange: IntRange,
    message: String = "Expected $otherRange but is instead $this"
): Unit = assertEquals(otherRange, this, message)

public inline fun IntRange.assertNot(
    otherRange: IntRange,
    message: String = "Expected $this to be different from $otherRange but they are the same"
): Unit = assertNotEquals(otherRange, this, message)
//endregion
