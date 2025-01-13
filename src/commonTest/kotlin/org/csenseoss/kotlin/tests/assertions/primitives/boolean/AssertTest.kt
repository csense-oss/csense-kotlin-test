package org.csenseoss.kotlin.tests.assertions.primitives.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    @Test
    fun correct() {
        true.assert(true)
        false.assert(false)
    }

    @Test
    fun throwsOnDifferent() {
        assertThrows<Throwable> {
            true.assert(false)
        }
        assertThrows<Throwable> {
            false.assert(true)
        }
    }
}