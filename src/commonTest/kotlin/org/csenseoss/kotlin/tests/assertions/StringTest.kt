package org.csenseoss.kotlin.tests.assertions

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.Test

class StringTest {

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