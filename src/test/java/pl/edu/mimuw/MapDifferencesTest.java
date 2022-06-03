package pl.edu.mimuw;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MapDifferencesTest {

  @Nested
  class DifferencesInKeySetOrder {

    /** HashMap ma nieokreśloną kolejność kluczy. */
    @Test
    void keySetOfHashMap() {
      Map<Integer, Integer> m = new HashMap<>();
      m.put(2, 200);
      m.put(1, 100);
      m.put(3, 300);
      Set<Integer> s = m.keySet();
      Iterator<Integer> it = s.iterator();

      assertEquals(1, it.next());
      assertEquals(2, it.next());
      assertEquals(3, it.next());
    }

    /** LinkedHashMap ma klucze w kolejności wstawiania. */
    @Test
    void keySetOfLinkedHashMap() {
      Map<Integer, Integer> m = new LinkedHashMap<>();
      m.put(2, 200);
      m.put(1, 100);
      m.put(3, 300);
      Set<Integer> s = m.keySet();
      Iterator<Integer> it = s.iterator();

      assertEquals(2, it.next());
      assertEquals(1, it.next());
      assertEquals(3, it.next());
    }

    /** TreeMap ma klucze w kolejności komparatora. */
    @Test
    void keySetOfTreeMap() {
      Map<Integer, Integer> m = new TreeMap<>((l, r) -> r - l);
      m.put(2, 200);
      m.put(1, 100);
      m.put(3, 300);
      Set<Integer> s = m.keySet();
      Iterator<Integer> it = s.iterator();

      assertEquals(3, it.next());
      assertEquals(2, it.next());
      assertEquals(1, it.next());
    }
  }

  @Nested
  class DifferencesInMethods {

    @Test
    /** Tylko TreeMap może zwrócić najmniejszy kluczy większy/równy danej liczbie. */
    void methodOfTreeMap() {
      TreeMap<Integer, Integer> m = new TreeMap<>();
      m.put(2, 200);
      m.put(1, 100);
      m.put(4, 300);

      assertEquals(300, m.ceilingEntry(3).getValue());
    }
  }

  @Nested
  class DifferenceInNullHandling {

    /** HashMap przyjmuje argumenty postaci null, null. */
    @Test
    void addingNullToHashMap() {
      Map<Integer, Integer> m = new HashMap<>();

      assertDoesNotThrow(() -> m.put(null, null));
    }

    /** LinkedHashMap przyjmuje argumenty postaci null, null. */
    @Test
    void addingNullToLinkedHashMap() {
      Map<Integer, Integer> m = new LinkedHashMap<>();

      assertDoesNotThrow(() -> m.put(null, null));
    }

    /** TreeMap nie przyjmuje elementów postaci null, null.  */
    @Test
    void addingNullToTreeMap() {
      Map<Integer, Integer> m = new TreeMap<>();

      assertThrows(NullPointerException.class, () -> m.put(null, null));
    }
  }
}
