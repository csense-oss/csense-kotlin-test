package org.csenseoss.kotlin.tests.assertions.general

@Suppress("RedundantNullableReturnType", "NOTHING_TO_INLINE")
public inline fun <T> (T & Any).nullable(): T? {
    return this
}