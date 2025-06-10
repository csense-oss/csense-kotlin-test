package org.csenseoss.kotlin.tests.assertions.pair

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import org.csenseoss.kotlin.tests.assertions.mocks.MapEntry
import kotlin.test.*

class AssertTest {

    class AssertPair {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(Pair("notFirst", "second"))
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(Pair("first", "notSecond"))

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(Pair("first", "second"))
        }
    }

    class AssertMapEntry {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(MapEntry("notFirst", "second"))
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(MapEntry("first", "notSecond"))

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert(MapEntry("first", "second"))
        }
    }


    class AssertParameters {
        @Test
        fun throwsWhenFirstDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert("notFirst", "second")
        }

        @Test
        fun throwsWhenSecondDifferent() = assertThrows<Throwable> {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert("first", "notSecond")

        }

        @Test
        fun continuesWhenMatching() = assertDoesNotThrow {
            val pair: Pair<String, String> = Pair("first", "second")
            pair.assert("first", "second")
        }
    }
}