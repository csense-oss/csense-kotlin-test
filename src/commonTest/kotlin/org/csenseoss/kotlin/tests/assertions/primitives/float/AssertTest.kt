package org.csenseoss.kotlin.tests.assertions.primitives.float

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    private val a: Float = 0.0F
    private val b: Float = 1.1F

    @Test
    fun same() {
        a.assert(0.0F)
        b.assert(1.1F)
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