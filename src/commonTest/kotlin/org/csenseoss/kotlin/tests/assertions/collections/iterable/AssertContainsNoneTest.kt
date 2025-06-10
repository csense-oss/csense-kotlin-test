package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertContainsNoneTest {


    @Test
    fun throwsWhenAll() = assertThrows<Throwable> {
        listOf("test").assertContainsNone("test")
    }

    @Test
    fun throwsWhenSome() = assertThrows<Throwable> {
        listOf("1234", "qwerty").assertContainsNone("qwerty")
    }

    @Test
    fun continuesWhenNone() = assertDoesNotThrow {
        listOf<String>().assertContainsNone("test")
    }
}