package org.csenseoss.kotlin.tests.assertions.coroutines

import kotlinx.coroutines.test.*
import org.csenseoss.kotlin.tests.assertions.*
import kotlin.coroutines.*
import kotlin.time.*
import kotlin.time.Duration.Companion.seconds

/**
 * Helper for "runTest" in the given dispatcher / context and wrapping the given [testBody] in [assertCalled]
 */
public fun runTestAssertCalled(
    context: CoroutineContext = EmptyCoroutineContext,
    timeout: Duration = 10.seconds,
    testBody: suspend TestScope.(shouldBeCalled: () -> Unit) -> Unit
): TestResult {
    return runTest(context = context, timeout = timeout) {
        assertCalled { shouldBeCalled: () -> Unit ->
            testBody(shouldBeCalled)
        }
    }
}

/**
 * Helper for "runTest" in the main dispatcher / context and wrapping the given [testBody] in [assertCalled]
 */
public fun runTestForMainDispatcherAssertCalled(
    timeout: Duration = 10.seconds,
    testBody: suspend TestScope.(shouldBeCalled: () -> Unit) -> Unit
) {
    runTestForMainDispatcher(timeout = timeout) {
        assertCalled { shouldBeCalled: () -> Unit ->
            testBody(shouldBeCalled)
        }
    }
}