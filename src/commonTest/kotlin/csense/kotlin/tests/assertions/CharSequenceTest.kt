package csense.kotlin.tests.assertions

import kotlin.test.Test

class CharSequenceTest {
    @Test
    fun charSequenceAssert() {
        val empty1: CharSequence = ""
        val empty2: CharSequence = ""
        val nonEmpty1: CharSequence = "1"
        val nonEmpty2: CharSequence = "2"
        val nonEmptyA: CharSequence = "A"
        val nonEmptya: CharSequence = "a"
        empty1.assert(empty2, ignoreCase = false)
        empty1.assert(empty2, ignoreCase = true)
        assertThrows<Throwable> {
            nonEmpty1.assert(nonEmpty2, ignoreCase = false)
        }
        assertThrows<Throwable> {
            nonEmpty1.assert(nonEmpty2, ignoreCase = true)
        }
        assertThrows<Throwable> {
            nonEmptya.assert(nonEmptyA, ignoreCase = false)
        }

        nonEmptya.assert(nonEmptyA, ignoreCase = true)

    }

    @Test
    fun charSequenceAssertNot() {
        val empty1: CharSequence = ""
        val empty2: CharSequence = ""
        val nonEmpty1: CharSequence = "1"
        val nonEmpty2: CharSequence = "2"
        val nonEmptyA: CharSequence = "A"
        val nonEmptya: CharSequence = "a"
        assertThrows<Throwable> {
            empty1.assertNot(empty2, ignoreCase = false)
        }
        assertThrows<Throwable> {
            empty1.assertNot(empty2, ignoreCase = true)
        }
        nonEmpty1.assertNot(nonEmpty2, ignoreCase = false)
        nonEmpty1.assertNot(nonEmpty2, ignoreCase = true)
        nonEmptya.assertNot(nonEmptyA, ignoreCase = false)
        assertThrows<Throwable> {
            nonEmptya.assertNot(nonEmptyA, ignoreCase = true)
        }
    }
}