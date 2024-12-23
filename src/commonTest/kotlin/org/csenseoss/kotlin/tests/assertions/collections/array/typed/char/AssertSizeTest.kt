package org.csenseoss.kotlin.tests.assertions.collections.array.typed.char

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        charArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        charArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        charArrayOf('5').assertSize(1)
    }

    @Test
    fun multiple() {
        charArrayOf('1', '2').assertSize(2)
    }
}