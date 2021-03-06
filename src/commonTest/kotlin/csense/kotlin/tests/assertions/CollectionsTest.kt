package csense.kotlin.tests.assertions

import kotlin.test.Test

class CollectionsTest {

    class CollectionTAssertSize {
        @Test
        fun empty() {
            listOf<Int>().assertSize(0)
            assertThrows<Throwable> {
                listOf<Int>().assertSize(1)
            }
        }

        @Test
        fun single() {
            listOf(42).assertSize(1)
            assertThrows<Throwable> {
                listOf(432).assertSize(2)
            }
            assertThrows<Throwable> {
                listOf(432).assertSize(0)
            }
        }

        @Test
        fun multiple() {
            listOf(42, 42, 2).assertSize(3)
            assertThrows<Throwable> {
                listOf(432, 44).assertSize(0)
            }
            assertThrows<Throwable> {
                listOf(432, 44).assertSize(1)
            }
            assertThrows<Throwable> {
                listOf(432, 44).assertSize(3)
            }
        }
    }

    @Test
    fun CollectionTAssertEmpty() {
        listOf<Int>().assertEmpty()
        assertThrows<Throwable> {
            listOf(432, 44).assertEmpty()
        }
        assertThrows<Throwable> {
            listOf(44).assertEmpty()
        }
    }

    class CollectionTAssertSingleCallback {
        @Test
        fun empty() {
            assertThrows<Throwable> {
                listOf<Int>().assertSingle {
                }
            }
        }

        @Test
        fun single() {
            assertCalled { shouldBeCalled ->
                listOf(42).assertSingle {
                    it.assert(42)
                    shouldBeCalled()
                }
            }
        }

        @Test
        fun multiple() {
            assertThrows<Throwable> {
                listOf(42, 42, 42).assertSingle {
                }
            }
        }
    }

    class CollectionTAssertSingleItem {
        @Test
        fun empty() {
            assertThrows<Throwable> {
                listOf<Int>().assertSingle(42)
            }
        }

        @Test
        fun single() {
            listOf(42).assertSingle(42)
            assertThrows<Throwable> {
                listOf(42).assertSingle(44)
            }
        }

        @Test
        fun multiple() {
            assertThrows<Throwable> {
                listOf(42, 42).assertSingle(44)
            }
            assertThrows<Throwable> {
                listOf(42, 42).assertSingle(42)
            }
        }
    }
}