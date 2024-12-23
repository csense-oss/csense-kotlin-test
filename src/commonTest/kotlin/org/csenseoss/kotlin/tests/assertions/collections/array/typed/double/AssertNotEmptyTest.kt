package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable>() {
        doubleArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        doubleArrayOf(1.0).assertNotEmpty()
    }


    @Test
    fun multiple() {
        doubleArrayOf(1.0, 2.0).assertNotEmpty()
    }
}