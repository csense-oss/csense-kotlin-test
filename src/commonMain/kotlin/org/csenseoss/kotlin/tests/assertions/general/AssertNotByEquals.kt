@file:Suppress("unused", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*
import kotlin.internal.*


public fun <@OnlyInputTypes T> T.assertNotByEquals(
    unexpected: T?,
    message: String? = null
) {
    val isNotEqual: Boolean = this?.equals(unexpected) != true
    isNotEqual.assertTrue(
        message = "Expected $this to be different (via equals) to $unexpected. ${message ?: ""}"
    )
}