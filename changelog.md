# 0.0.50
- kotlin 1.5.30
- fixed bug with assertCallsCallbackWith
- more collection extensions
- documentation updates

# 0.0.49

- use of @kotlin.internal.OnlyInputTypes to limit type misuse for generic extension functions
- use kotlin jvm IR

# 0.0.48

- fixed issue with string.assert{not} not logging the expected value

# 0.0.47

- added assertCallbackCalledWith
- added CharSequence.assert & CharSequence.assertNot

# 0.0.46

- more Extensions
- fixed assertContainsInOrder for strings (did not have default ignoreCase parameter) and added a varag overload
- updated strings assertions to have "ignoreCase"
- updated char assertions to have "ignoreCase"
- minor bugs fixed
- updated array's assertSingle to have the action as the last parameter

# 0.0.45

- added more extensions for Map
    - assertContainsKey
    - assertDoesNotContainsKey
    - assertContains
    - updates to assertSingle
    - assertContainsKeyAnd
- updated the message for assertAs
- more deprecations due to naming

# 0.0.44

- documentation fixed for MPP

# 0.0.43

- fixed a bug with assertEmpty on arrays

# 0.0.42

- removed enum assert as all enums are comparable ( caused overload resolution ambiguity)
- fixed multiple bug with assertNot
- added readme

# 0.0.41

- kotlin 1.4.21
- more extensions (arrays & collections)
- minor code cleanup
- removed list extensions that were also on collection's
- naming updated to more "assert" rather than assertEqual (what else should you assert? equals is redundant)
- removed number.assert as all numbers in kotlin is comparable

# 0.0.40

- kotlin 1.4.0
- updated contracts
- spelling mistakes fixed

# 0.0.36

- documentation (a lot of improved and added documentation)
- all functions inline
- more extensions and more refined extensions
- removed mini benchmark (from jvm) as Kotlinx.benchmark exists & JMH exists

# 0.0.35

- catch up with csense kotlin versions
- contracts

# 0.0.27

- more assert functions

# 0.0.26

- more test functions

# 0.0.25

- match csense kotlin version.

# 0.0.24

- code got separated into own package and repo.

# 0.0.23

- kotlin 1.3.60