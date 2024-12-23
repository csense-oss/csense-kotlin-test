package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable> {
        floatArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        floatArrayOf(1f).assertNotEmpty()
    }


    @Test
    fun multiple() {
        floatArrayOf(1f, 2f).assertNotEmpty()
    }
}