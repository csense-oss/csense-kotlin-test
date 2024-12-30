//@file:Suppress("unused")
//
//package org.csenseoss.kotlin.tests.assertions
//
//import org.csenseoss.kotlin.tests.assertions.general.*
//import org.csenseoss.kotlin.tests.assertions.helpers.*
//
//
///**
// * Asserts that this string contains some substrings in order (increasing), such that you may say "there is some x, followed by y"
// * @receiver [String] the string to assert contains the values in order
// * @param strings [Array]<[String]> the list of strings to be contained in order, eg "x followed by y by z", so y have to come after x. ect.
// * @param ignoreCase [Boolean] if true, will ignore casing, if false, all contains are case-sensitive.
// * @param message [String] the error message
// */
//public fun String.assertContainsInOrder(
//    vararg strings: String,
//    ignoreCase: Boolean = false,
//    message: String = ""
//) {
//    assertContainsInOrder(values = strings.toList(), ignoreCase = ignoreCase, message = message)
//}
//
///**
// * Asserts that this string contains some substrings in order (increasing), such that you may say "there is some x, followed by y"
// * @receiver [String] the string to assert contains the values in order
// * @param values [List]<[String]> the list of values to be contained in order, eg "x followed by y by z", so y have to come after x. ect.
// * @param ignoreCase [Boolean] if true, will ignore casing, if false, all contains are case-sensitive.
// * @param message [String] the error message
// */
//public fun String.assertContainsInOrder(
//    values: List<String>,
//    ignoreCase: Boolean = false,
//    message: String = ""
//) {
//    var currentIndex = 0
//    values.forEach {
//        val next = indexOf(it, currentIndex, ignoreCase)
//        if (next < 0) {
//            val messageWithNewline = message.helpers.useIfNotEmptyOrThis(message + "\n\n")
//            failTest(
//                "{$messageWithNewline}Could not find \n\t\"$it\" after index $currentIndex in string \n" +
//                        "\"$this\"\n" +
//                        "\tafter index is :\"${this.substring(currentIndex)}\""
//            )
//        }
//        currentIndex = next + it.length
//    }
//}