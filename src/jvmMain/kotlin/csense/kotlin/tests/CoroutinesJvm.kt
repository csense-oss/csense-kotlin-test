package csense.kotlin.tests

import csense.kotlin.tests.assertions.*
import kotlinx.coroutines.*


public fun CoroutineScope.assertDispatcherIO() {
    assertDispatcher(Dispatchers.IO)
}