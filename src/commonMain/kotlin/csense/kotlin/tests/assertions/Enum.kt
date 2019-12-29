@file:Suppress("unused", "NOTHING_TO_INLINE", "MissingTestFunction")

package csense.kotlin.tests.assertions

import kotlin.test.*


fun <T : Enum<T>> Enum<T>.assert(other: Enum<T>) {
    assertEquals(this, other)
}