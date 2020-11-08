package csense.kotlin.tests.assertions

//contains extensions for this test module not for user code
/**
 * If this is empty, empty is returned, otherwise the given string is
 * @receiver String
 * @param ifNotEmptyString String
 * @return String
 */
internal fun String.useIfNotEmptyOrThis(ifNotEmptyString: String): String {
    if (this.isEmpty()) {
        return this
    }
    return ifNotEmptyString
}