package org.csenseoss.kotlin.tests.assertions.collections.array.typed.short

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        shortArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        shortArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        shortArrayOf(5).assertSize(1)
    }

    @Test
    fun multiple() {
        shortArrayOf(1, 2).assertSize(2)
    }
}