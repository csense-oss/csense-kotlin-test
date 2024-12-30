package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertEmptyTest {
    @Test
    fun empty() {
        arrayOf<String>().assertEmpty()
    }

    @Test
    fun throwsOnNonEmpty() = assertThrows<Throwable> {
        arrayOf("test").assertEmpty()
    }

    @Test
    fun throwsOnMultiple() = assertThrows<Throwable> {
        arrayOf("first", "second").assertEmpty()
    }
}