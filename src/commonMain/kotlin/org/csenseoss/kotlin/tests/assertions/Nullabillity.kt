package org.csenseoss.kotlin.tests.assertions


public object Nullabillity {

}

fun <T, U> assertNullabillityEqualsOr(
    actual: T?,
    expected: U?,
    message: String = "",
    orByAssert: (T, U) -> Unit
) {
    if (actual != null && expected != null) {
        orByAssert(actual, expected)
        return
    }
    val isEqual: Boolean = actual == null && expected == null
    if (!isEqual) {
        
    }
}