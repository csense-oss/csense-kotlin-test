package org.csenseoss.kotlin.tests.assertions.collections.iterable.iterable

import org.csenseoss.kotlin.tests.assertions.exceptions.*
import kotlin.test.*

class AssertTest {
    @Test
    fun emptyToEmpty() = assertDoesNotThrow {
        val input: List<List<String>> = listOf()
        input.assert()
    }

    @Test
    fun emptyWithEmptyToEmptyWithEmpty() = assertDoesNotThrow {
        val input: List<List<String>> = listOf(listOf())
        input.assert(listOf())
    }

    @Test
    fun singleToEmptyThrows() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf(listOf())
        input.assert()
    }

    @Test
    fun emptyToSingleThrows() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf()
        input.assert(listOf())
    }

    @Test
    fun singleToSingleMatches() = assertDoesNotThrow {
        val input: List<List<String>> = listOf(listOf("test"))
        input.assert(listOf("test"))
    }

    @Test
    fun singleToSingleDoesNotMatch() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf(listOf("abcd"))
        input.assert(listOf("1234"))
    }

    @Test
    fun multipleToMultipleMatches() = assertDoesNotThrow {
        val input: List<List<String>> = listOf(listOf("abcd", "1234"), listOf("qwerty"))
        input.assert(listOf("abcd", "1234"), listOf("qwerty"))
    }

    @Test
    fun multipleToMultipleMismatches() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf(listOf("abcd", "1234"), listOf("____"))
        input.assert(listOf("abcd", "1234"), listOf("qwerty"))
    }

    @Test
    fun singleToMultipleMismatchesSizes() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf(listOf("abcd", "1234"))
        input.assert(listOf("abcd", "1234"), listOf("qwerty"))
    }
    @Test
    fun multipleToSingleMismatchesSizes() = assertThrows<Throwable> {
        val input: List<List<String>> = listOf(listOf("abcd", "1234"), listOf("qwerty"))
        input.assert(listOf("abcd", "1234"))
    }
}