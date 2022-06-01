package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapDifferencesTest {

  @Nested
  class DifferenceInIterationOrder {
    @Test
    void iterateTreeMap() {
      Map<String, Integer> s = new TreeMap<>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      var z = new ArrayList<>(s.values());
      assertEquals(List.of(1, 2, 3), z);
    }

    @Test
    void iterateHashSet() {
      Map<String, Integer> s = new HashMap<>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      var z = new ArrayList<>(s.values());

      // The iterator goes through all the elements but in no specific order.
      z.sort(Integer::compare);
      assertEquals(List.of(1, 2, 3), z);
    }

    @Test
    void iterateLinkedHashSet() {
      Map<String, Integer> s = new LinkedHashMap<>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      var z = new ArrayList<>(s.values());
      assertEquals(List.of(1, 3, 2), z);
    }
  }

  @Nested
  class DifferencesInMethods {
    @Test
    void testTreeMapMethods() {
      var s = new TreeMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      assertEquals(3, s.size());

      // Only for the tree map.
      assertEquals(1, s.firstEntry().getValue());
      assertEquals(3, s.lastEntry().getValue());
    }

    @Test
    void testHashMapMethods() {
      var s = new HashMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      assertEquals(3, s.size());
    }

    @Test
    void testLinkedHashMapMethods() {
      var s = new LinkedHashMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      assertEquals(3, s.size());
    }
  }

  @Nested
  class DifferencesInAddingAnElementTwice {
    @Test
    void testAddingAnElementTwiceToATreeMap() {
      var s = new TreeMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      s.put("b", 2);
      assertEquals(3, s.size());
      var z = new ArrayList<>(s.values());
      assertEquals(List.of(1, 2, 3), z);
    }

    @Test
    void testAddingAnElementTwiceToAHashMap() {
      var s = new HashMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      s.put("b", 2);
      assertEquals(3, s.size());
    }

    @Test
    void testAddingAnElementTwiceToALinkedHashMap() {
      var s = new LinkedHashMap<String, Integer>();
      s.put("a", 1);
      s.put("d", 3);
      s.put("b", 2);
      s.put("d", 4);
      assertEquals(3, s.size());
      var z = new ArrayList<>(s.values());
      assertEquals(List.of(1, 4, 2), z);
    }
  }
}
