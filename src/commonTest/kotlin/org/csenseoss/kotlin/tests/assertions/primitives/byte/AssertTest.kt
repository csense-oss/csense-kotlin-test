package org.csenseoss.kotlin.tests.assertions.primitives.byte

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    private val a: Byte = 0
    private val b: Byte = 1

    @Test
    fun same() {
        a.assert(0)
        b.assert(1)
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