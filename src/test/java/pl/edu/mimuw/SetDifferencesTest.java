package pl.edu.mimuw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SetDifferencesTest {

  @Nested
  class DifferenceInIterationOrder {

    /** TreeSet przetrzymuje elementy uporządkowane przez komparator. */
    @Test
    void iterateTreeSet() {
      Set<Integer> s = new TreeSet<>((l, r) -> r - l);
      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();

      assertEquals(3, it.next());
      assertEquals(2, it.next());
      assertEquals(1, it.next());
    }

    /** HashSet przetrzymuje elementy w nieznanej kolejności. */
    @Test
    void iterateHashSet() {
      Set<Integer> s = new HashSet<>();
      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();

      assertEquals(1, it.next());
      assertEquals(2, it.next());
      assertEquals(3, it.next());
    }

    /** HashSet przetrzymuje elementy w kolejności dodania. */
    @Test
    void iterateLinkedHashSet() {
      Set<Integer> s = new LinkedHashSet<>();

      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();

      assertEquals(2, it.next());
      assertEquals(1, it.next());
      assertEquals(3, it.next());
    }
  }

  @Nested
  class DifferenceInAddRemove {

    /** TreeSet nie zmienia kolejności elementów po odjęciu i dodaniu tego samego elementu. */
    @Test
    void addRemoveInTreeSet() {
      Set<Integer> s = new TreeSet<>();
      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();
      int first = it.next();
      s.remove(first);
      s.add(first);
      it = s.iterator();
      int newfirst = it.next();
      assertEquals(first, newfirst);
    }

    /** HashSet nie zmienia kolejności elementów po odjęciu i dodaniu tego samego elementu. */
    @Test
    void addRemoveInHashSet() {
      Set<Integer> s = new HashSet<>();
      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();
      int first = it.next();
      s.remove(first);
      s.add(first);
      it = s.iterator();
      int newfirst = it.next();
      assertEquals(first, newfirst);
    }

    /** LinkedHashSett zmienia kolejność elementów po odjęciu i dodaniu tego samego elementu. */
    @Test
    void addRemoveInLinkedHashSet() {
      Set<Integer> s = new LinkedHashSet<>();

      s.add(2);
      s.add(1);
      s.add(3);
      Iterator<Integer> it = s.iterator();
      int first = it.next();
      s.remove(first);
      s.add(first);
      it = s.iterator();
      int newfirst = it.next();
      assertNotEquals(first, newfirst);
    }
  }

  @Nested
  class DifferenceInMethods {

    /** Tylko TreeSet może zwrócić podprzedział elementów większych/równych od a i mniejszych od b. */
    @Test
    void addRemoveInTreeSet() {
      SortedSet<Integer> s = new TreeSet<>();
      s.add(2);
      s.add(1);
      s.add(3);
      SortedSet<Integer> newSet = s.subSet(1, 2);
      assertEquals(1, newSet.size());
    }
  }
}
