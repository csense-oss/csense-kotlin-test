package org.csenseoss.kotlin.tests.assertions.exceptions

import kotlin.test.*

class AssertThrowsCauseTest {
    @Test
    fun throwsIfNoException() = assertThrows<Throwable> {
        assertThrowsCause<Throwable, Throwable> {
            //no-op
        }
    }

    @Test
    fun continuesIfActionThrowsException() = assertDoesNotThrow {
        assertThrowsCause<Throwable, Throwable> {
            throw RuntimeException()
        }
    }

    @Test
    fun throwsIfCauseIsMismatching() = assertThrows<Throwable> {
        assertThrowsCause<Throwable, IllegalArgumentException> {
            throw Exception("message", NullPointerException())
        }
    }
}