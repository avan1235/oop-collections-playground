package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Iterator;

class SetDifferencesTest {
	@Nested
	class DifferencesInIterationOrder {
		@Test
		void testHashSetIterationOrder() {
			Set<Integer> s = new HashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
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
		void testLinkedHashSetIterationOrder() {
			Set<Integer> s = new LinkedHashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(42, it.next());
			assertEquals(69, it.next());
			assertEquals(21, it.next());
			assertEquals(37, it.next());
		}
		
		@Test
		void testTreeSetIterationOrder() {
			Set<Integer> s = new TreeSet<Integer>((l, r) -> r - l);
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(69, it.next());
			assertEquals(42, it.next());
			assertEquals(37, it.next());
			assertEquals(21, it.next());
		}
	}
	
	@Nested
	class DifferencesInRemovingAnElement {
		@Test
		void testHashSetRemoveAnElement() {
			Set<Integer> s = new HashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.remove(21);
			
			Iterator<Integer> it = s.iterator();
			
			/**
			 * Random order, checked empirically.
			 */
			assertEquals(69, it.next());
			assertEquals(37, it.next());
			assertEquals(42, it.next());
		}
		
		@Test
		void testLinkedHashSetRemoveAnElement() {
			Set<Integer> s = new LinkedHashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.remove(21);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(42, it.next());
			assertEquals(69, it.next());
			assertEquals(37, it.next());
		}
		
		@Test
		void testTreeSetRemoveAnElement() {
			Set<Integer> s = new TreeSet<Integer>((l, r) -> r - l);
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.remove(21);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(69, it.next());
			assertEquals(42, it.next());
			assertEquals(37, it.next());
		}
	}
	
	@Nested
	class DifferencesInAddingAnElementTwice {
		@Test
		void testHashSetAddAnElementTwice() {
			Set<Integer> s = new HashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.add(42);
			
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
		void testLinkedHashSetAddAnElementTwice() {
			Set<Integer> s = new LinkedHashSet<Integer>();
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.add(42);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(42, it.next());
			assertEquals(69, it.next());
			assertEquals(21, it.next());
			assertEquals(37, it.next());
		}
		
		@Test
		void testTreeSetAddAnElementTwice() {
			Set<Integer> s = new TreeSet<Integer>((l, r) -> r - l);
			
			s.add(42);
			s.add(69);
			s.add(21);
			s.add(37);
			
			s.add(42);
			
			Iterator<Integer> it = s.iterator();
			
			assertEquals(69, it.next());
			assertEquals(42, it.next());
			assertEquals(37, it.next());
			assertEquals(21, it.next());
		}
	}
}
