package org.csenseoss.kotlin.tests.assertions.collections.map

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*


/**
 * Asserts that this map has content
 * @receiver [Map]<*, *>
 * @param message [String] the message if this map's size is 0 / is Empty
 */
public fun Map<*, *>.assertNotEmpty(
    message: String = "Map should have content"
): Unit =
    this.isNotEmpty().assertTrue(message = message)