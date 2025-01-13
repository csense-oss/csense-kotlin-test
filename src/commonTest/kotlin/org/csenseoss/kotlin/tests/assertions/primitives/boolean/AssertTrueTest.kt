package org.csenseoss.kotlin.tests.assertions.primitives.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTrueTest {

    @Test
    fun falseOnTrueShouldThrow(): Unit = assertThrows<Throwable> {
        false.assertTrue()
    }

    @Test
    fun trueOnTrueIsOk() {
        true.assertTrue()
    }
}