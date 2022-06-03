# Collections playground

In this task your goal is ot play with different implementations of some collections.
You should take a look at the collections' documentation and try to find the differences.
Spotted difference may take into account different behaviour of some common methods as
well as different set of methods (and an example how they work).
Your solution should be provided as a few `Test` classes that will be available in
`src/test/java/pl/edu/mimuw`. Organize your tests in some categories e.g. to show how the order of insertion
works in case of each implementation - use [@Nested](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested)
tests to organize your work. For each required check provide at least 3 different categories of
differences for these collections.

Required checks:
1. Map<K, V> interface - play with:
   1. HashMap
   2. LinkedHashMap
   3. TreeMap
2. Set<V> interface - play with:
   1. HashSet
   2. LinkedHashSet
   3. TreeSet
3. Queue<V>  - play with:
   1. ArrayDeque
   2. LinkedList
   3. PriorityQueue

You can get 1 point for this task - deadline is 04.06.2022 (23:59). Remember about code quality and
formatting of your tests (keep clean naming of classes and methods) to make your solution readable and more
pleasant for readers.
