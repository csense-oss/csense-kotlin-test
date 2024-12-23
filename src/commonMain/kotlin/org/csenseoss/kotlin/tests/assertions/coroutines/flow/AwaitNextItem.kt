package org.csenseoss.kotlin.tests.assertions.coroutines.flow

import kotlinx.coroutines.flow.*


public suspend fun <T> Flow<T>.awaitNextItem(): T {
    return first { _: T ->
        true
    }
}