package org.csenseoss.kotlin.tests.assertions.collections.array.typed.long

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        longArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        longArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        longArrayOf(5).assertSize(1)
    }

    @Test
    fun multiple() {
        longArrayOf(1, 2).assertSize(2)
    }
}