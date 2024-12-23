package org.csenseoss.kotlin.tests.assertions.exceptions

import org.csenseoss.kotlin.tests.assertions.comparable.*
import org.csenseoss.kotlin.tests.assertions.general.*


public fun Throwable?.assert(expected: Throwable, message: String = "") {
    if (this == null) {
        failTest("Expected $expected but got null;$message")
    }
    if (this::class != expected::class) {
        failTest("Mismatching types. Expected $expected but got $this;$message")
    }

    this.message.assertOrNull(expected.message, String::assert)
//
//    val otherMessage: String? = expected.message
//    if (otherMessage != null) {
//        this.message.assert(otherMessage, message)
//    } else {
//        this.message.assertNull()
//    }
    this.cause.assertOrNull(expected.cause, Throwable::assert)
//    val otherCause: Throwable? = expected.cause
//    if (otherCause != null) {
//        this.cause.assert(otherCause, message)
//    } else {
//        this.cause.assertNull()
//    }
}

//TODO hmm...
private fun <T> T?.assertOrNull(other: T?, assertMethod: (T, T) -> Unit) {
    when {
        this == null && other == null -> return
        this != null && other != null -> return assertMethod(this, other)
        this == null -> failTest("")
        other == null -> failTest("")
    }
}