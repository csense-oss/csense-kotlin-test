@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package csense.kotlin.tests.assertions

import kotlin.math.abs
import kotlin.test.*

//region Double
/**
 * Asserts that this [Double] is equal to the other double (given the [delta] / margin to account for imprecision)
 * @receiver [Double] the actual value
 * @param value [Double] the value we expect
 * @param delta [Double] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public fun Double.assert(
    value: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        return
    }
    val errorMessage = "expected $value within $delta margins, but got $this."
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}


/**
 *
 * @receiver Double
 * @param value Double
 * @param delta Double
 * @param message String
 */
public fun Double.assertNot(
    value: Double,
    delta: Double = 0.1,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        failTest("Both $this and $value are NaN's, but expected them to be different")
    }
    val errorMessage = "expected $value to be different from $this within $delta margins, but they are equal."
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
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
public fun Float.assert(
    value: Float,
    delta: Float = 0.1f,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        return
    }
    val errorMessage = "expected $value within $delta margins, but got $this."
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}


/**
 *
 * @receiver Float
 * @param value Double
 * @param delta Double
 * @param message String
 */
public fun Float.assertNot(
    value: Float,
    delta: Float = 0.1F,
    message: String = ""
) {
    if (this.isNaN() && value.isNaN()) {
        failTest("Both $this and $value are NaN's, but expected them to be different")
    }
    val errorMessage = "expected $value to be different from $this within $delta margins, but they are equal."
    val safeDelta = abs(delta)
    assertFalse(this >= value - safeDelta && this <= value + safeDelta, errorMessage + message)
}
//endregion


//region Char
/**
 * Asserts this [Char] is the same as the given [value]
 * @receiver [Char] the actual char
 * @param value [Char] the expected char
 * @param message [String] the message to show if they differ
 */
public fun Char.assert(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual = this.equals(value, ignoreCase)
    if (!isEqual) {
        val errorMessage = "Expected $value but is instead $this."
        failTest(errorMessage + message)
    }
}

/**
 *
 * @receiver Char
 * @param value Char
 * @param message String
 */
public fun Char.assertNot(
    value: Char,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    val isEqual = this.equals(value, ignoreCase)
    if (isEqual) {
        val errorMessage = "Expected '$this' to be different from '$value', but they are the same."
        failTest(errorMessage + message)
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
public fun Byte.assert(value: Byte, message: String = ""): Unit {
    val errorMessage = "Expected $value but is instead $this."
    assertEquals(value, this, errorMessage + message)
}

public fun Byte.assertNot(
    value: Byte,
    message: String = ""
): Unit {
    val errorMessage = "Expected $value to be different from $this but they are the same."
    assertNotEquals(value, this, errorMessage + message)
}
//endregion

//region IntRange
/**
 * Asserts this range is the same as [otherRange]
 * @receiver [IntRange] the actual range
 * @param otherRange [IntRange] the expected range
 * @param message [String] the message to show if they differ
 */
public fun IntRange.assert(
    otherRange: IntRange,
    message: String = ""
): Unit {
    val errorMessage = "Expected $otherRange but is instead $this."
    assertEquals(otherRange, this, errorMessage + message)
}

public fun IntRange.assertNot(
    otherRange: IntRange,
    message: String = ""
): Unit {
    val errorMessage = "Expected $this to be different from $otherRange but they are the same."
    assertNotEquals(otherRange, this, errorMessage + message)
}
//endregion

