package csense.kotlin.tests.assertions

import kotlin.test.Test

class StringTest {
    class StringAssertContains {

        @Test
        fun emptyString() {
            "".assertContains("")
            assertThrows<Throwable> {
                "".assertContains("test")
            }
        }

        @Test
        fun singleWord() {
            assertThrows<Throwable> {
                "asd".assertContains("test")
            }
            "asd".assertContains("asd")
        }

        @Test
        fun multipleWords() {
            assertThrows<Throwable> {
                "asd 123".assertContains("test")
            }
            "asd test".assertContains("test")
        }


        @Test
        fun singleWordCasing() {
            assertThrows<Throwable> {
                "asd".assertContains("AsD", ignoreCase = false)
            }
            "asd".assertContains("ASD", ignoreCase = true)
        }

        @Test
        fun multipleWordsCasing() {
            assertThrows<Throwable> {
                "asd 123".assertContains("asD", ignoreCase = false)
            }
            "asd tESt".assertContains("TesT", ignoreCase = true)
        }
    }


    class StringAssertContainsNot {

        @Test
        fun emptyString() {
            "".assertContainsNot("test")
            assertThrows<Throwable> {
                "".assertContainsNot("")
            }
        }

        @Test
        fun singleWord() {
            assertThrows<Throwable> {
                "asd".assertContainsNot("asd")
            }
            "asd".assertContainsNot("test")
        }

        @Test
        fun multipleWords() {
            assertThrows<Throwable> {
                "asd test".assertContainsNot("test")
            }
            "asd 123".assertContainsNot("test")
        }


        @Test
        fun singleWordCasing() {
            assertThrows<Throwable> {
                "asd".assertContainsNot("ASD", ignoreCase = true)
            }
            "asd".assertContainsNot("AsD", ignoreCase = false)
        }

        @Test
        fun multipleWordsCasing() {
            assertThrows<Throwable> {
                "asd tESt".assertContainsNot("TesT", ignoreCase = true)
            }
            "asd 123".assertContainsNot("asD", ignoreCase = false)
        }
    }

    @Test
    fun stringAssertNotEmpty() {
        assertThrows<Throwable> {
            "".assertNotEmpty()
        }
        " ".assertNotEmpty()
    }

    @Test
    fun stringAssertEmpty() {

        "".assertEmpty()
        assertThrows<Throwable> {
            " ".assertEmpty()
        }

    }

    class StringAssert {
        @Test
        fun shouldWorkOnNormalNonNullStrings() {
            "".assert("")
            assertThrows<Throwable> {
                "".assert("test")
            }
            assertThrows<Throwable> {
                "test".assert("")
            }
            "test".assert("test")

            assertThrows<Throwable> {
                "tesT".assert("test", ignoreCase = false)
            }
            assertThrows<Throwable> {
                "tesT".assert("Test", ignoreCase = false)
            }

            "Test".assert("test", ignoreCase = true)

            "tESt".assert("TesT", ignoreCase = true)
        }

        @Test
        fun assertShouldWorkOnNullableString() = assertThrows<Throwable> {
            val str: String? = null
            str.assert("")
        }

        @Test
        fun assertShouldWorkOnNullableIgnoreCaseString() = assertThrows<Throwable> {
            val str: String? = null
            str.assert("abC", ignoreCase = true)
        }

    }

    @Test
    fun stringAssertNot() {
        "".assertNot("test")
        assertThrows<Throwable> {
            "".assertNot("")
        }
        assertThrows<Throwable> {
            "test".assertNot("test")
        }
        "test".assertNot("")

        assertThrows<Throwable> {
            "tESt".assertNot("TesT", ignoreCase = true)
        }

        "tesT".assertNot("test", ignoreCase = false)

        assertThrows<Throwable> {
            "Test".assertNot("test", ignoreCase = true)
        }
        "tesT".assertNot("Test", ignoreCase = false)


    }

    @Test
    fun stringAssertStartsWith() {
        "".assertStartsWith("")
        assertThrows<Throwable> {
            "".assertStartsWith("test")
        }
        assertThrows<Throwable> {
            "a test".assertStartsWith("test")
        }
        "test".assertStartsWith("test")
        "test abc 123".assertStartsWith("test")

        assertThrows<Throwable> {
            "TeSt".assertStartsWith("tesT", ignoreCase = false)
        }
        "TeSt".assertStartsWith("tEsT", ignoreCase = true)
    }

    @Test
    fun stringAssertEndsWith() {
        "".assertEndsWith("")
        assertThrows<Throwable> {
            "".assertEndsWith("test")
        }
        assertThrows<Throwable> {
            "test abc 123".assertEndsWith("test")
        }
        "a test".assertEndsWith("test")
        "test".assertEndsWith("test")

        assertThrows<Throwable> {
            "TeSt".assertEndsWith("tesT", ignoreCase = false)
        }
        "TeSt".assertEndsWith("tEsT", ignoreCase = true)
    }

    class StringAssertContainsInOrderStrings {
        @Test
        fun empty() {
            "".assertContainsInOrder()
        }

        @Test
        fun singleNotThere() = assertThrows<Throwable> {
            "".assertContainsInOrder("test")
        }

        @Test
        fun singleThere() {
            "test a b c".assertContainsInOrder("b")
        }

        @Test
        fun multipleNotThere() = assertThrows<Throwable> {
            "test".assertContainsInOrder("a", "b")
        }

        @Test
        fun multipleThereNotInOrder() = assertThrows<Throwable> {
            "b a".assertContainsInOrder("a", "b")
        }

        @Test
        fun multipleThereInOrder() {
            "b a c".assertContainsInOrder("b", "a", "c")
        }

        @Test
        fun multipleThereInOrderSkipsUnused() {
            "b a c".assertContainsInOrder("b", "c")
        }
    }


    class StringAssertContainsInOrderValues {
        @Test
        fun empty() {
            "".assertContainsInOrder(listOf())
        }

        @Test
        fun singleNotThere() = assertThrows<Throwable> {
            "".assertContainsInOrder(listOf("test"))
        }

        @Test
        fun singleThere() {
            "test a b c".assertContainsInOrder(listOf("b"))
        }

        @Test
        fun multipleNotThere() = assertThrows<Throwable> {
            "test".assertContainsInOrder(listOf("a", "b"))
        }

        @Test
        fun multipleThereNotInOrder() = assertThrows<Throwable> {
            "b a".assertContainsInOrder(listOf("a", "b"))
        }

        @Test
        fun multipleThereInOrder() {
            "b a c".assertContainsInOrder(listOf("b", "a", "c"))
        }

        @Test
        fun multipleThereInOrderSkipsUnused() {
            "b a c".assertContainsInOrder(listOf("b", "c"))
        }

    }
}