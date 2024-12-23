package org.csenseoss.kotlin.tests.assertions.collections.array.generic

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {

    @Test
    fun empty() = assertThrows<Throwable> {
        arrayOf<String>().assertNotEmpty()
    }


    @Test
    fun single() {
        arrayOf("test").assertNotEmpty()
    }


    @Test
    fun multiple() {
        arrayOf("test", "1234").assertNotEmpty()
    }
}