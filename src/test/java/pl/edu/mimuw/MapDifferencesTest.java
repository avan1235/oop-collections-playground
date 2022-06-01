package pl.edu.mimuw;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MapDifferencesTest {
    @Nested
    class DifferencesInKeySetOrder {
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
        void methodOfTreeMap() {
            TreeMap<Integer, Integer> m = new TreeMap<>();
            m.put(2, 200);
            m.put(1, 100);
            m.put(4, 300);
            
            assertEquals(300, m.ceilingEntry(3).getValue());
        }
    }
}
