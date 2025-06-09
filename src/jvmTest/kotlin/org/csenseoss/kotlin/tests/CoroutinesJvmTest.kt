package org.csenseoss.kotlin.tests

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*
import org.junit.jupiter.api.*

class CoroutinesJvmTest {

    @Nested
    inner class AssertDispatcherIO {

        @Test
        fun throwsOnDefault() = runTest {
            var didCall = false
            launch(Dispatchers.Default) {
                assertThrows<Throwable> {
                    didCall = true
                    assertDispatcherIO()
                }
            }.join()
            didCall.assertTrue()
        }

        @Test
        fun worksInIO() = runTest {
            launch(Dispatchers.IO) {
                assertDispatcherIO()
            }.join()
        }
    }
}