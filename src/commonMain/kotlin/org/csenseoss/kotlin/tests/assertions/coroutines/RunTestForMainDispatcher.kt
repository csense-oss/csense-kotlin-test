package org.csenseoss.kotlin.tests.assertions.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.csenseoss.kotlin.tests.assertions.*
import kotlin.time.*
import kotlin.time.Duration.Companion.seconds

/**
 * Helper for "runTest" in the main dispatcher / context
 */
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