@file:OptIn(ExperimentalCoroutinesApi::class)

package csense.kotlin.tests.assertions

import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import kotlin.contracts.*

@Suppress("UnusedReceiverParameter")
public inline fun Dispatchers.withMain(
    dispatcher: CoroutineDispatcher,
    action: () -> Unit
) {
    contract {
        callsInPlace(action, InvocationKind.EXACTLY_ONCE)
    }
    Dispatchers.setMain(dispatcher)
    action()
    Dispatchers.resetMain()
}
