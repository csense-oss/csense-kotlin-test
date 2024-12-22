package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.*
import kotlin.test.*

class AssertSizeTest {
    @Test
    fun empty() {
        arrayOf<String>().assertSize(0)
    }

    @Test
    fun throwsOnWrongSize() = assertThrows<Throwable> {
        arrayOf<String>().assertSize(1)
    }


    @Test
    fun single() {
        arrayOf("test").assertSize(1)
    }

    @Test
    fun multiple() {
        arrayOf("first", "second").assertSize(2)
    }
}