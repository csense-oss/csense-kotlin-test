# Csense kotlin test (mpp)

## Intro

This libraries focus is to provide a short, simple and easy to use test assertions and like. Its MPP which means it does
not have a lot of fancy JVM (or other platform) stuff, but instead relies on very simple assertions it is a fluent api,
meaning that:
**Before**

```kotlin
@Test
fun test() {
    assertEqual("is this expected?", "or is this actual?")
}
```

**After**

```kotlin
@Test
fun test() {
    "is this expected?".assert("or is this actual?")
}
```

These makes code read more like a sentence. It further also removes the confusion about expected vs actual, as you always
start with what you have(the actual), which is a lot closer to how you would think ("is this the right result?")

## Showcases

### Double & float

*margins*

**Before**

```kotlin
val doubleToTest = 0.0
val expected = 1.0
val margin = 0.01 //since doubles are imprecise 
assertTrue(doubleToTest >= (expected - margin) && doubleToTest <= (expected + margin))
```

**After**

```kotlin
val doubleToTest = 0.0
val expected = 1.0
val margin = 0.01
doubleToTest.assert(expected, margin = margin)
//even the default assert has a margin of 0.1 (very loose)
```

There is even an "assertNot" with margins as well.

### Collections

**Before**

*size*

```kotlin
val collectionToTest = listOf<String>()
assertEquals(0, collectionToTest.size)
```

**After**

```kotlin
val collectionToTest = listOf<String>()
collectionToTest.assertEmpty()
```

*ordering*

**Before**

```kotlin
val collectionToTest = listOf<String>()
assertTrue(collectionToTest.contains("test"))
assertTrue(collectionToTest.contains("test2"))
```

**After**

```kotlin
val collectionToTest = listOf<String>()
collectionToTest.assertContainsAll("test", "test2")
```
