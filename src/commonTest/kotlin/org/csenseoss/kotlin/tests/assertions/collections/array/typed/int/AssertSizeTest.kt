package org.csenseoss.kotlin.tests.assertions.collections.array.typed.int

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        intArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        intArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        intArrayOf(22).assertSize(1)
    }

    @Test
    fun multiple() {
        intArrayOf(22, 22).assertSize(2)
    }
}