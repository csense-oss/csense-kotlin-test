package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that this map is empty.
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size differs from empty
 */
public fun Map<*, *>.assertEmpty(
    message: String = "Map should be empty but is not."
): Unit = this.isEmpty().assertTrue(message = message)