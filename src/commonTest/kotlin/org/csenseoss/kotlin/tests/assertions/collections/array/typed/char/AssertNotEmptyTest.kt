package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun empty() = assertThrows<Throwable> {
        charArrayOf().assertNotEmpty()
    }


    @Test
    fun single() {
        charArrayOf('a').assertNotEmpty()
    }


    @Test
    fun multiple() {
        charArrayOf('a', 'b').assertNotEmpty()
    }
}