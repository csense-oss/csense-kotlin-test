@file:Suppress("unused", "NOTHING_TO_INLINE", "INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package csense.kotlin.tests.assertions


public inline fun <@kotlin.internal.OnlyInputTypes Key, @kotlin.internal.OnlyInputTypes Value> Map.Entry<Key, Value>?.assert(
    key: Key,
    value: Value
) where Key : Comparable<Key>, Value : Comparable<Value> {
    assertNotNull()
    this.key.assert(key)
    this.value.assert(value)
}


public inline fun <Key, Value> Map.Entry<Key, Value>?.assertByEquals(
    key: Key,
    value: Value
) {
    assertNotNull()
    this.key.assertByEquals(key)
    this.value.assertByEquals(value)
}

