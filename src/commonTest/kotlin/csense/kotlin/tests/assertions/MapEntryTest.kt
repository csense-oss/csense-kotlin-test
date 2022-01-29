package csense.kotlin.tests.assertions

import kotlin.test.*

class MapEntryTest {
    class MapEntryKeyValueAssert {

        @Test
        fun nullReceiverShouldFail() = assertThrows<Throwable> {
            val map: MapEntry? = null
            map.assert("1", "2")
        }

        @Test
        fun mismatchingKeyShouldThrow() = assertThrows<Throwable> {
            val map = MapEntry("1", "2")
            map.assert(key = "2", value = "2")
        }

        @Test
        fun mismatchingValueShouldThrow() = assertThrows<Throwable> {
            val map = MapEntry("1", "2")
            map.assert(key = "1", value = "3")
        }

        @Test
        fun matchingShouldPass() {
            val map = MapEntry("1", "2")
            map.assert(key = "1", value = "2")
        }

    }
}

private class MapEntry(override val key: String, override val value: String) : Map.Entry<String, String>