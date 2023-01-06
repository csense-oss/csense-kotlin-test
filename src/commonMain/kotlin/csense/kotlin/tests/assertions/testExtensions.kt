package csense.kotlin.tests.assertions

//contains extensions for this test module (stored away in a namespace called "helpers")

public data class TestHelpers<T>(val value: T)

public inline val <T> T.helpers: TestHelpers<T>
    get() = TestHelpers(this)

public fun <T> TestHelpers<T>?.simpleClassNameOrDash(): String {
    this ?: return "-"
    return this::class.simpleName ?: "-"
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