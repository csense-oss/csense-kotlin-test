package org.csenseoss.kotlin.tests.assertions.collections.iterable

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertNotEmptyTest {
    @Test
    fun throwsWhenNotEmpty() = assertThrows<Throwable> {
        listOf<String>().assertNotEmpty()
    }

    @Test
    fun continuesWhenEmpty() = assertDoesNotThrow {
        listOf("test").assertNotEmpty()
    }
}