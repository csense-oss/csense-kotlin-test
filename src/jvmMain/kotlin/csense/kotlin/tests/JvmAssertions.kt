@file:Suppress("unused")

package csense.kotlin.tests

import csense.kotlin.tests.assertions.*

/**
 * Asserts the receiver and arguments are the same class Type instance
 * @receiver Class<*>
 * @param expected Class<*>
 */
public fun Class<*>?.assert(expected: Class<*>) {
    (this === expected).assertTrue("class type should be same (thus reference should since its singleton)\n receiver is $this, argument is $expected")
}
