package org.csenseoss.kotlin.tests.assertions.general

import org.csenseoss.kotlin.tests.assertions.*
import org.csenseoss.kotlin.tests.assertions.texts.*


/**
 * As the name suggest, calling this means failure.
 */
public fun shouldNotBeCalled(message: String = GeneralStrings.assertNotCalledMessage): Nothing {
    failTest(message)
}