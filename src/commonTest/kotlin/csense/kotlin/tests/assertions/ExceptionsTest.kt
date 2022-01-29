package csense.kotlin.tests.assertions

import kotlin.test.*

class ExceptionsTest {


    class ThrowableAssert {
        @Test
        fun nullToNonNullShouldThrow() = assertThrows<Throwable> {
            val nullable: Throwable? = null
            nullable.assert(Exception())
        }

        @Test
        fun differentMessageShouldThrow() = assertThrows<Throwable> {
            val exception: Throwable = Exception("message A")
            exception.assert(Exception("message B"))
        }

        @Test
        fun differentTypeShouldThrow() = assertThrows<Throwable> {
            val exception: Throwable = RuntimeException("message A")
            exception.assert(IndexOutOfBoundsException("message B"))
        }

        @Test
        fun sameShouldPass() {
            val exception: Throwable = Exception("message A")
            exception.assert(Exception("message A"))
        }

        @Test
        fun shouldThrowOnDifferentCauses() = assertThrows<Throwable> {
            val value = Exception("Test", Exception("A"))
            val other = Exception("Test", Exception("B"))
            value.assert(other)
        }

        @Test
        fun shouldPassOnSameCauses() {
            val value = Exception("Test", Exception("A"))
            val other = Exception("Test", Exception("A"))
            value.assert(other)
        }
    }
}