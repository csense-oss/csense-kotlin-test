@file:Suppress("NOTHING_TO_INLINE")
package org.csenseoss.kotlin.tests.assertions.general

@Suppress("RedundantNullableReturnType")
public inline fun <T> (T & Any).nullable(): T? {
    return this
}