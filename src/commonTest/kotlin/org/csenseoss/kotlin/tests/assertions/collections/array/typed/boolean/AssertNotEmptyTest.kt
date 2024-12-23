package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable>() {
        booleanArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        booleanArrayOf(true).assertNotEmpty()
    }


    @Test
    fun multiple() {
        booleanArrayOf(false, true).assertNotEmpty()
    }
}