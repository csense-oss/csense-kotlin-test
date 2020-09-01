@file:Suppress("MissingTestFunction", "NOTHING_TO_INLINE")

package csense.kotlin.tests.assertions

import kotlin.math.*
import kotlin.test.*

/**
 * Asserts that this [Double] is equal to the other double (given the [delta] / margin to account for imprecision)
 * @receiver [Double] the actual value
 * @param value [Double] the value we expect
 * @param delta [Double] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public inline fun Double.assert(value: Double, delta: Double = 0.1, message: String = "expected $value within $delta margins, but got $this") {
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, message)
}

/**
 * Asserts that this [Float] is equal to the other float (given the [delta] / margin to account for imprecision)
 * @receiver [Float] the actual value
 * @param value [Float] the value we expect
 * @param delta [Float] the "allowed imprecision" for value to differ from the receiver
 * @param message [String] the message to show if they differ by more than [delta]
 */
public inline fun Float.assert(value: Float, delta: Float = 0.1f, message: String = "expected $value within $delta margins, but got $this") {
    val safeDelta = abs(delta)
    assertTrue(this >= value - safeDelta && this <= value + safeDelta, message)
}

/**
 * Asserts this number is the same as the given [value]
 * @receiver T the actual value
 * @param value T the expected value
 * @param message [String] the message to show if they differ
 */
public inline fun <T : Number> T.assert(value: T, message: String = "Expected $value but is instead $this") {
    assertEquals(value, this, message)
}

/**
 * Asserts this [Char] is the same as the given [value]
 * @receiver [Char] the actual char
 * @param value [Char] the expected char
 * @param message [String] the message to show if they differ
 */
public inline fun Char.assert(value: Char, message: String = "Expected $value but is instead $this") {
    assertEquals(value, this, message)
}

/**
 * Asserts this byte is the same as the given [value]
 * @receiver [Byte] the actual value
 * @param value [Byte] the expected value
 * @param message [String] the message to show if they differ
 */
public inline fun Byte.assert(value: Byte, message: String = "Expected $value but is instead $this") {
    assertEquals(value, this, message)
}

/**
 * Asserts this range is the same as [otherRange]
 * @receiver [IntRange] the actual range
 * @param otherRange [IntRange] the expected range
 * @param message [String] the message to show if they differ
 */
public inline fun IntRange.assert(otherRange: IntRange, message: String = "Expected $otherRange but is instead $this") {
    assertEquals(otherRange, this, message)
}