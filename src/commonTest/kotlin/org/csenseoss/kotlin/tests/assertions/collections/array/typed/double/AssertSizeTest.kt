package org.csenseoss.kotlin.tests.assertions.collections.array.typed.double

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        doubleArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        doubleArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        doubleArrayOf(0.5).assertSize(1)
    }

    @Test
    fun multiple() {
        doubleArrayOf(1.0, 2.54).assertSize(2)
    }
}