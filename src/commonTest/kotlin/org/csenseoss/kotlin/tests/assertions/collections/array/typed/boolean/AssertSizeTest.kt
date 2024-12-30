package org.csenseoss.kotlin.tests.assertions.collections.array.typed.boolean

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        booleanArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        booleanArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        booleanArrayOf(false).assertSize(1)
    }

    @Test
    fun multiple() {
        booleanArrayOf(false, true).assertSize(2)
    }
}