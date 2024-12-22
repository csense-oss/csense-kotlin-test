package org.csenseoss.kotlin.tests

import kotlinx.coroutines.*
import org.csenseoss.kotlin.tests.assertions.coroutines.*


public fun CoroutineScope.assertDispatcherIO() {
    assertDispatcher(Dispatchers.IO)
}