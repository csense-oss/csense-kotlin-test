package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.general.*
import kotlin.contracts.*


public fun <T> Iterable<T>?.assertContainsAllByEquals(
    vararg items: T,
    message: String = "Expected to find item, but was not found:"
) {
    contract { returns() implies (this@assertContainsAllByEquals != null) }

    this.assertNotNull()
    items.forEach { it: T ->
        assertContainsByEquals(it, message + it)
    }
}


public fun <T> Iterable<T>?.assertContainsAllByEquals(
    items: Iterable<T>,
    message: String = "Expected to find item, but was not found:"
) {
    contract { returns() implies (this@assertContainsAllByEquals != null) }

    this.assertNotNull()
    items.forEach { it: T ->
        assertContainsByEquals(it, message + it)
    }
}