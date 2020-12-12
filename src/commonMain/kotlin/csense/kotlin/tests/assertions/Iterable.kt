@file:Suppress("unused", "NOTHING_TO_INLINE")

package csense.kotlin.tests.assertions


/**
 * Asserts that the given [items] are contained in the receiver by the given order (by the iterator)
 * @receiver [Iterable]<[T]> the iterable to search though
 * @param items [Array]<out T> The items we are expected to find in the receiver
 */
public inline fun <T> Iterable<T>.assertContainsInOrder(
    vararg items: T
) {
    assertContainsInOrder(items.toList())
}

/**
 * Asserts that the given [items] are contained in the receiver by the given order (by the iterator)
 * @receiver [Iterable]<T> the iterable to search though
 * @param items [Iterable]<T> the items we are expected to find in the receiver
 */
public inline fun <T> Iterable<T>.assertContainsInOrder(
    items: Iterable<T>
) {
    val itemsCount = count()
    val count = this.count()
    if (itemsCount == 0 || count == 0) {
        failTest("Either the asserted items is empty or the receiver is empty, thus failing not matter what...")
    }
    if (itemsCount > count) {
        failTest("Collection is not big enough to contain the given items in order. this collection is $count, but items size is $itemsCount")
    }

    val iterator = items.iterator()
    var lastFoundElementIndex: Int? = null
    var lastFoundElement: T? = null
    var currentItem: T = iterator.next() //assumed to work given the 0 case is handled
    forEachIndexed { index: Int, item: T ->
        if (item == currentItem) {
            if (iterator.hasNext()) {
                currentItem = iterator.next()
                lastFoundElementIndex = index
                lastFoundElement = item
            } else {
                return@assertContainsInOrder //we are done.
            }
        }
    }
    val lastFoundMessage = if (lastFoundElementIndex == null) {
        "<nowhere>"
    } else {
        lastFoundElementIndex.toString()
    }
    failTest("Could not find `$currentItem`, last successful found item was at index $lastFoundMessage, which is `$lastFoundElement`")
}