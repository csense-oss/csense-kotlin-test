package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {

    @Test
    fun empty() = assertThrows<Throwable> {
        intArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        intArrayOf(1).assertNotEmpty()
    }


    @Test
    fun multiple() {
        intArrayOf(1, 2).assertNotEmpty()
    }

}