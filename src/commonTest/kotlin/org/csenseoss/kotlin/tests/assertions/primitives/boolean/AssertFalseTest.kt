package org.csenseoss.kotlin.tests.assertions.primitives.boolean

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertFalseTest {

    @Test
    fun falseOnFalseIsOk() {
        false.assertFalse()
    }

    @Test
    fun trueOnFalseShouldThrow(): Unit = assertThrows<Throwable> {
        true.assertFalse()
    }

}