package csense.kotlin.tests.assertions

import kotlin.test.Test

class MapTest {
    class MapAssertSize {
        @Test
        fun empty() {
            mapOf<Int, Int>().assertSize(0)
            assertThrows<Throwable> {
                mapOf<Int, Int>().assertSize(1)
            }
        }

        @Test
        fun single() {
            mapOf(42 to 22).assertSize(1)
            assertThrows<Throwable> {
                mapOf(42 to 22).assertSize(0)
            }
            assertThrows<Throwable> {
                mapOf(42 to 22).assertSize(2)
            }
        }

        @Test
        fun multiple() {
            mapOf(42 to 22, 44 to 21).assertSize(2)
            assertThrows<Throwable> {
                mapOf(42 to 22, 44 to 21).assertSize(1)
            }
            assertThrows<Throwable> {
                mapOf(42 to 22, 44 to 21).assertSize(3)
            }
        }
    }

    class MapAssertEmpty {
        @Test
        fun empty() {
            mapOf<Int, Int>().assertEmpty()
        }

        @Test
        fun single() {
            assertThrows<Throwable> {
                mapOf(42 to 22).assertEmpty()
            }
        }

        @Test
        fun multiple() {
            assertThrows<Throwable> {
                mapOf(42 to 22, 44 to 21).assertEmpty()
            }
        }
    }


    class MapAssertNotEmpty {
        @Test
        fun empty() {
            assertThrows<Throwable> {
                mapOf<Int, Int>().assertNotEmpty()
            }
        }

        @Test
        fun single() {
            mapOf(44 to 21).assertNotEmpty()
        }

        @Test
        fun multiple() {
            mapOf(42 to 22, 44 to 21).assertNotEmpty()
        }
    }

    class MapKeyValueAssertSingleItem {
        @Test
        fun empty() {
            assertThrows<Throwable> {
                mapOf<Int, Int>().assertSingle(42 to 42)
            }
        }

        @Test
        fun single() {
            assertThrows<Throwable> {
                mapOf(22 to 42).assertSingle(42 to 42)
            }
            mapOf(42 to 33).assertSingle(42 to 33)
            assertThrows<Throwable> {
                mapOf(21 to 44).assertSingle(21 to 42)
            }
        }

        @Test
        fun multiple() {
            assertThrows<Throwable> {
                mapOf(22 to 42, 55 to 21).assertSingle(42 to 42)
            }
        }
    }


}
