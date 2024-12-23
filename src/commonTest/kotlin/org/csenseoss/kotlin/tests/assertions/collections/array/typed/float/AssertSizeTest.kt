package org.csenseoss.kotlin.tests.assertions.collections.array.typed.float

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        floatArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        floatArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        floatArrayOf(3f).assertSize(1)
    }

    @Test
    fun multiple() {
        floatArrayOf(1f, 2.1f).assertSize(2)
    }
}