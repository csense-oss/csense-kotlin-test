@file:Suppress("unused")

package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.coroutines.*
import kotlin.time.*
import kotlin.time.Duration.Companion.seconds

public fun CoroutineScope.assertDispatcherDefault() {
    assertDispatcher(Dispatchers.Default)
}

public fun CoroutineScope.assertDispatcherMain() {
    assertDispatcher(Dispatchers.Main)
}

public fun CoroutineScope.assertDispatcherUnconfined() {
    assertDispatcher(Dispatchers.Unconfined)
}

public fun CoroutineScope.assertDispatcher(otherDispatcher: CoroutineDispatcher) {
    getCurrentDispatcher().assertAs(otherDispatcher)
}

private fun CoroutineScope.getCurrentDispatcher() = coroutineContext.getCurrentDispatcher()

private fun CoroutineContext.getCurrentDispatcher(): CoroutineDispatcher =
    this[ContinuationInterceptor] as CoroutineDispatcher


public fun runTestForMainDispatcher(
    timeout: Duration = 10.seconds,
    testBody: suspend TestScope.() -> Unit
): TestResult {
    val testDispatcher: TestDispatcher = StandardTestDispatcher()
    val result: TestResult
    Dispatchers.withMain(testDispatcher) {
        result = runTest(
            context = testDispatcher,
            timeout = timeout,
            testBody = testBody
        )
    }
    return result
}

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