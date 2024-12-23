package org.csenseoss.kotlin.tests.assertions.collections.array.typed.byte

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        byteArrayOf().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        byteArrayOf().assertSize(1)
    }


    @Test
    fun single() {
        byteArrayOf(5).assertSize(1)
    }

    @Test
    fun multiple() {
        byteArrayOf(1, 2).assertSize(2)
    }
}