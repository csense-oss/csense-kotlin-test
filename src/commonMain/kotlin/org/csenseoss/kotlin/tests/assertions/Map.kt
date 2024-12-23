@file:Suppress("unused")

package org.csenseoss.kotlin.tests.assertions

import org.csenseoss.kotlin.annotations.numbers.*
import kotlin.contracts.*
import kotlin.test.*






/**
 * Asserts that this [Map] contains the given [Pair] (by key then value)
 * @receiver [Map]<Key, Value>
 * @param keyValue [Pair]<Key, Value> the key to find and then the value to assert
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContains(
    keyValue: Pair<Key, Value>
) {
    val value: Value? = get(keyValue.first)
    value.assertNotNull("key \"${keyValue.first}\" not found in ($keys)")
    value.assertAs(keyValue.second)
}

/**
 * Asserts that this [Map] contains the given key and runs the given [ifFoundAction]
 * @receiver Map<Key, Value>
 * @param key [Key] the key to search for
 * @param ifFoundAction Function1<Value, Unit> the function to execute if the key was found
 */
public inline fun <Key, reified Value> Map<Key, Value>.assertContainsKeyAnd(
    key: Key,
    ifFoundAction: (Value) -> Unit
) {
    val value: Value? = get(key)
    value.assertNotNull("key \"$key\" not found in ($keys)")
    ifFoundAction(value)
}