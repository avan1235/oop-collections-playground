package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetDifferencesTest {

  @Nested
  class DifferenceInIterationOrder {
    @Test
    void iterateTreeSet() {
      Set<Integer> s = new TreeSet<>(List.of(5, 2, 3, 1, 4));
      var z = new ArrayList<>(s);
      assertEquals(List.of(1, 2, 3, 4, 5), z);
    }

    @Test
    void iterateHashSet() {
      Set<Integer> s = new HashSet<>(List.of(5, 2, 3, 1, 4));
      var z = new ArrayList<>(s);

      // The iterator goes through all the elements but in no specific order.
      z.sort(Integer::compare);
      assertEquals(List.of(1, 2, 3, 4, 5), z);
    }

    @Test
    void iterateLinkedHashSet() {
      Set<Integer> s = new LinkedHashSet<>(List.of(5, 2, 3, 1, 4));
      var z = new ArrayList<>(s);
      assertEquals(List.of(5, 2, 3, 1, 4), z);
    }
  }

  @Nested
  class DifferencesInMethods {
    @Test
    void testTreeSetMethods() {
      var s = new TreeSet<>(List.of(5, 2, 3, 1, 4));
      assertEquals(5, s.size());

      // Only for the tree set.
      assertEquals(1, s.first());
      assertEquals(5, s.last());
    }

    @Test
    void testHashSetMethods() {
      var s = new HashSet<>(List.of(5, 2, 3, 1, 4));
      assertEquals(5, s.size());
    }

    @Test
    void testLinkedHashSetMethods() {
      var s = new LinkedHashSet<>(List.of(5, 2, 3, 1, 4));
      assertEquals(5, s.size());
    }
  }

  @Nested
  class DifferencesInAddingAnElementTwice {
    @Test
    void testAddingAnElementTwiceToATreeSet() {
      var s = new TreeSet<>(List.of(5, 2, 3, 1, 4));
      s.add(3);
      assertEquals(5, s.size());
      var z = new ArrayList<>(s);
      assertEquals(List.of(1, 2, 3, 4, 5), z);
    }

    @Test
    void testAddingAnElementTwiceToAHashSet() {
      var s = new HashSet<>(List.of(5, 2, 3, 1, 4));
      s.add(3);
      assertEquals(5, s.size());
    }

    @Test
    void testAddingAnElementTwiceToALinkedHashSet() {
      var s = new LinkedHashSet<>(List.of(5, 2, 3, 1, 4));
      s.add(3);
      assertEquals(5, s.size());
      var z = new ArrayList<>(s);
      assertEquals(List.of(5, 2, 3, 1, 4), z);
    }
  }
}
