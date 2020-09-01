@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

/**
 * Assert that this map have the given size.
 * @receiver [Map]<*, *>
 * @param expectedSize [Int] the expected size of this map
 * @param message [String] the message if this map's size differs from the [expectedSize]
 */
public inline fun Map<*, *>.assertSize(
    expectedSize: Int,
    message: String = "Expected the map to have a size of $expectedSize, but it is instead ${this.size}"
): Unit =
    this.size.assert(expectedSize, message)

/**
 * Asserts that this map is empty.
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size differs from empty
 */
public inline fun Map<*, *>.assertEmpty(
    message: String = "Map should be empty but is not."
): Unit =
    this.isEmpty().assertTrue(message)