package org.csenseoss.kotlin.tests.assertions.pair

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.mocks.MapEntry
import kotlin.test.*

class AssertByEqualsTest {

    class AssertByEqualsPair {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(Pair("notFirst", "second"))
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(Pair("first", "notSecond"))

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(Pair("first", "second"))
        }
    }

    class AssertByEqualsMapEntry {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(MapEntry("notFirst", "second"))
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(MapEntry("first", "notSecond"))

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals(MapEntry("first", "second"))
        }
    }


    class AssertByEqualsParameters {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals("notFirst", "second")
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals("first", "notSecond")

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assertByEquals("first", "second")
        }
    }
}