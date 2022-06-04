package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;

class MapDifferencesTest {
	@Nested
	class DifferencesInKeySetOrder {
		@Test
		void testHashMapKeySetOrder() {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Set<Integer> s = m.keySet();
			Iterator<Integer> it = s.iterator();
			
			/**
			 * Random order, checked empirically.
			 */
			assertEquals(69, it.next());
			assertEquals(21, it.next());
			assertEquals(37, it.next());
			assertEquals(42, it.next());
		}
		
		@Test
		void testLinkedHashMapKeySetOrder() {
			Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Set<Integer> s = m.keySet();
			Iterator<Integer> it = s.iterator();
			
			assertEquals(42, it.next());
			assertEquals(69, it.next());
			assertEquals(21, it.next());
			assertEquals(37, it.next());
		}
		
		@Test
		void testTreeMapKeySetOrder() {
			Map<Integer, Integer> m = new TreeMap<Integer, Integer>((l, r) -> r - l);
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Set<Integer> s = m.keySet();
			Iterator<Integer> it = s.iterator();
			
			assertEquals(69, it.next());
			assertEquals(42, it.next());
			assertEquals(37, it.next());
			assertEquals(21, it.next());
		}
	}
	
	@Nested
	class DifferencesInValuesOrder {
		@Test
		void testHashMapValuesOrder() {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Collection<Integer> c = m.values();
			Iterator<Integer> it = c.iterator();
			
			/**
			 * Random order, checked empirically.
			 */
			assertEquals(1, it.next());
			assertEquals(3, it.next());
			assertEquals(7, it.next());
			assertEquals(2, it.next());
		}
		
		@Test
		void testLinkedHashMapValuesOrder() {
			Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Collection<Integer> c = m.values();
			Iterator<Integer> it = c.iterator();
			
			assertEquals(2, it.next());
			assertEquals(1, it.next());
			assertEquals(3, it.next());
			assertEquals(7, it.next());
		}
		
		@Test
		void testTreeMapValuesOrder() {
			Map<Integer, Integer> m = new TreeMap<Integer, Integer>((l, r) -> r - l);
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			Collection<Integer> c = m.values();
			Iterator<Integer> it = c.iterator();
			
			assertEquals(1, it.next());
			assertEquals(2, it.next());
			assertEquals(7, it.next());
			assertEquals(3, it.next());
		}
	}
	
	@Nested
	class DifferencesInOverwrite {
		@Test
		void testHashMapOverwrite() {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			m.put(21, 15);
			
			Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
			
			/**
			 * Random order, checked empirically.
			 */
			Map.Entry<Integer, Integer> entry = it.next();
			assertEquals(69, entry.getKey());
			assertEquals(1, entry.getValue());
			entry = it.next();
			assertEquals(21, entry.getKey());
			assertEquals(15, entry.getValue());
			entry = it.next();
			assertEquals(37, entry.getKey());
			assertEquals(7, entry.getValue());
			entry = it.next();
			assertEquals(42, entry.getKey());
			assertEquals(2, entry.getValue());
		}
		
		@Test
		void testLinkedHashMapOverwrite() {
			Map<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			m.put(21, 15);
			
			Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
			
			Map.Entry<Integer, Integer> entry = it.next();
			assertEquals(42, entry.getKey());
			assertEquals(2, entry.getValue());
			entry = it.next();
			assertEquals(69, entry.getKey());
			assertEquals(1, entry.getValue());
			entry = it.next();
			assertEquals(21, entry.getKey());
			assertEquals(15, entry.getValue());
			entry = it.next();
			assertEquals(37, entry.getKey());
			assertEquals(7, entry.getValue());
		}
		
		@Test
		void testTreeMapOverwrite() {
			Map<Integer, Integer> m = new TreeMap<Integer, Integer>((l, r) -> r - l);
			
			m.put(42, 2);
			m.put(69, 1);
			m.put(21, 3);
			m.put(37, 7);
			
			m.put(21, 15);
			
			Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
			
			Map.Entry<Integer, Integer> entry = it.next();
			assertEquals(69, entry.getKey());
			assertEquals(1, entry.getValue());
			entry = it.next();
			assertEquals(42, entry.getKey());
			assertEquals(2, entry.getValue());
			entry = it.next();
			assertEquals(37, entry.getKey());
			assertEquals(7, entry.getValue());
			entry = it.next();
			assertEquals(21, entry.getKey());
			assertEquals(15, entry.getValue());
		}
	}
}
