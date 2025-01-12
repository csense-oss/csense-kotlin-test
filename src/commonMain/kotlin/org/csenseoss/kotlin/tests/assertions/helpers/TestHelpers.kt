package org.csenseoss.kotlin.tests.assertions.helpers

//contains extensions for this test module (stored away in a namespace called "helpers")

public data class TestHelpers<T : Any>(
    val value: T
)

public inline val <T : Any> T.helpers: TestHelpers<T>
    get() = TestHelpers(this)

public fun <T : Any> TestHelpers<T>?.simpleClassNameOrDash(): String {
    this ?: return "-"
    return value::class.simpleName ?: "-"
}

/**
 * If this is empty, empty is returned, otherwise the given string is
 * @receiver String
 * @param ifNotEmptyString String
 * @return String
 */
public fun TestHelpers<String>.useIfNotEmptyOrThis(ifNotEmptyString: String): String {
    if (value.isEmpty()) {
        return value
    }
    return ifNotEmptyString
}