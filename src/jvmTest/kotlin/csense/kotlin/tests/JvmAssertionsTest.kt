package csense.kotlin.tests

import csense.kotlin.tests.assertions.*
import org.junit.jupiter.api.Test

class JvmAssertionsTest {
    class ClassAssert {

        @Test
        fun nullToNonNullShouldThrow() = assertThrows<Throwable> {
            val nullableString: Class<String>? = null
            nullableString.assert(String::class.java)
        }

        @Test
        fun sameShouldPass() {
            val nullableString: Class<String>? = String::class.java
            nullableString.assert(String::class.java)
        }

        @Test
        fun differentShouldThrow() = assertThrows<Throwable> {
            val nullableString: Class<String>? = null
            nullableString.assert(Int::class.java)
        }
    }
}