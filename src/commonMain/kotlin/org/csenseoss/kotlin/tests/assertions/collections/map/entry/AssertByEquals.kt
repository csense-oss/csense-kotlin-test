package org.csenseoss.kotlin.tests.assertions.collections.map.entry

import org.csenseoss.kotlin.tests.assertions.general.*


public inline fun <Key, Value> Map.Entry<Key, Value>?.assertByEquals(
    key: Key,
    value: Value
) {
    assertNotNull()
    this.key.assertByEquals(key)
    this.value.assertByEquals(value)
}