package org.csenseoss.kotlin.tests.assertions.primitives.boolean

import kotlin.test.*

class AssertTest {
    @Test
    fun booleanAssert() {
        true.assert(true)
        false.assert(false)
    }
}