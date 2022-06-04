package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class MapDifferencesTest {
  @Nested
  class KeySearchingDifferences {
    @Test
    void inHashMap() {
      HashMap<String, Integer> m = new HashMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 2);
      m.put("trzeci", 3);

      assertEquals(m.containsKey("pierw"), false);
    }

    @Test
    void inTreeMap() {
      TreeMap<String, Integer> m = new TreeMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 2);
      m.put("trzeci", 3);

      assertEquals(m.ceilingKey("pierw"), "pierwszy");
    }
  }

  @Nested
  class DeletingDifferences {
    @Test
    void inHashMap() {
      HashMap<String, Integer> m = new HashMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 2);

      m.remove("pierwszy");

      assertEquals(false, m.containsKey("pierwszy"));

    }

    @Test
    void inLinkedHashMap() {
      LinkedHashMap<String, Integer> m = new LinkedHashMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 2);

      m.clear();

      assertEquals(false, m.containsKey("drugi"));
    }

    @Test
    void inTreeMap() {
      TreeMap<String, Integer> m = new TreeMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 2);

      m.pollFirstEntry();

      assertEquals(m.lastKey(), "pierwszy");
    }
  }

  @Nested
  class ReplaceDifferences {
    @Test
    void inHashMap() {
      HashMap<String, Integer> m = new HashMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 6);
      m.put("trzeci", 3);

      m.replace("drugi", 2);

      assertEquals(2, m.get("drugi"));
    }

    @Test
    void inTreeMap() {
      TreeMap<String, Integer> m = new TreeMap<>();
      m.put("pierwszy", 1);
      m.put("drugi", 4);
      m.put("trzeci", 3);

      m.replace("drugi", 2);

      assertEquals(2, m.get("drugi"));
    }
  }
}
