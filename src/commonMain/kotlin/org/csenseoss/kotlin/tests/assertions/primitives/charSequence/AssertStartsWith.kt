package org.csenseoss.kotlin.tests.assertions.primitives.charSequence

import org.csenseoss.kotlin.tests.assertions.general.*
import org.csenseoss.kotlin.tests.assertions.helpers.*
import org.csenseoss.kotlin.tests.assertions.primitives.boolean.*

/**
 * Asserts that this string starts with the given string.
 * @receiver [String] the string to assert starts with the given string
 * @param prefix [String] the string to be asserted to be started with
 * @param ignoreCase [Boolean] if true, will ignore casing, if false, all contains are case sensitive.
 * @param message [String] the error message if the start differs from the given prefix
 */
public fun CharSequence?.assertStartsWith(
    prefix: CharSequence,
    ignoreCase: Boolean = false,
    message: String = ""
) {
    this.assertNotNull()
    val messageWithNewline = message.helpers.useIfNotEmptyOrThis(message + "\n")
    val textOutput: String = """
        ${messageWithNewline}Could not find "$prefix", in  
        "$this"
        """.trimIndent()
    this.startsWith(prefix, ignoreCase = ignoreCase).assertTrue(textOutput)
}