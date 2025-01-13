package org.csenseoss.kotlin.tests.assertions.primitives.double

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    private val a: Double = 0.0
    private val b: Double = 1.1

    @Test
    fun same() {
        a.assert(0.0)
        b.assert(1.1)
    }

    @Test
    fun different() {
        assertThrows<Throwable> {
            a.assert(b)
        }
        assertThrows<Throwable> {
            b.assert(a)
        }
    }
}