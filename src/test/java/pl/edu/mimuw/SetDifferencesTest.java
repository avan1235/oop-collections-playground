package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetDifferencesTest {
  @Nested
  class IterationDifferences {
    @Test
    void inHashSet() {
      HashSet<Integer> s = new HashSet<>();

      s.add(1);
      s.add(12);
      s.add(123);
      s.add(1234);

      Iterator<Integer> i = s.iterator();

      assertEquals(1, i.next());
      assertEquals(1234, i.next());
      assertEquals(123, i.next());
      assertEquals(12, i.next());

    }
    @Test
    void inLinkedHashSet() {
      LinkedHashSet<Integer> s = new LinkedHashSet<>();

      s.add(1);
      s.add(12);
      s.add(123);
      s.add(1234);

      Iterator<Integer> i = s.iterator();

      assertEquals(1, i.next());
      assertEquals(12, i.next());
      assertEquals(123, i.next());
      assertEquals(1234, i.next());

    }
    @Test
    void inTreeSet() {
      TreeSet<Integer> s = new TreeSet<>();

      s.add(1);
      s.add(12);
      s.add(123);
      s.add(1234);

      Iterator<Integer> i = s.iterator();

      assertEquals(1, i.next());
      assertEquals(12, i.next());
      assertEquals(123, i.next());
      assertEquals(1234, i.next());

    }
  }

  @Nested
  class AddingDifferences {
    @Test
    void inHashSet() {
      HashSet<Integer> s = new HashSet<>();

      s.add(1);
      s.add(2);
      s.add(3);

      assertEquals(3, s.size());

    }
    @Test
    void inLinkedHashSet() {
      LinkedHashSet<Integer> s = new LinkedHashSet<>();

      s.add(1);
      s.add(2);
      s.add(3);

      assertEquals(3, s.size());

    }

    @Test
    void inTreeSet() {
      TreeSet<Integer> s = new TreeSet<>();

      Collection<Integer> c = new ArrayList<>();
      c.add(1);
      c.add(2);
      c.add(3);

      s.addAll(c);

      assertEquals(3, s.size());

    }
  }

}
