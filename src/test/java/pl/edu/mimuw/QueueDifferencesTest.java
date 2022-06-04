package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;

class QueueDifferencesTest {
	@Nested
	class DifferencesInPoll {
		@Test
		void testArrayDequePoll() {
			Queue<Integer> q = new ArrayDeque<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(42, q.poll());
			assertEquals(69, q.poll());
			assertEquals(21, q.poll());
			assertEquals(37, q.poll());
		}
		
		@Test
		void testLinkedListPoll() {
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(42, q.poll());
			assertEquals(69, q.poll());
			assertEquals(21, q.poll());
			assertEquals(37, q.poll());
		}
		
		@Test
		void testPriorityQueuePoll() {
			Queue<Integer> q = new PriorityQueue<Integer>((l, r) -> r - l);
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(69, q.poll());
			assertEquals(42, q.poll());
			assertEquals(37, q.poll());
			assertEquals(21, q.poll());
		}
	}
	
	@Nested
	class DifferencesInPeek {
		@Test
		void testArrayDequePeek() {
			Queue<Integer> q = new ArrayDeque<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(42, q.peek());
		}
		
		@Test
		void testLinkedListPeek() {
			Queue<Integer> q = new LinkedList<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(42, q.peek());
		}
		
		@Test
		void testPriorityQueuePeek() {
			Queue<Integer> q = new PriorityQueue<Integer>((l, r) -> r - l);
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			assertEquals(69, q.peek());
		}
	}
	
	@Nested
	class DifferencesInMethods {
		@Test
		void testArrayDequeMethods() {
			ArrayDeque<Integer> q = new ArrayDeque<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			q.addFirst(10);
			q.addLast(99);
			
			assertEquals(10, q.getFirst());
			assertEquals(99, q.getLast());
		}
		
		@Test
		void testLinkedListMethods() {
			LinkedList<Integer> q = new LinkedList<Integer>();
			
			q.offer(42);
			q.offer(69);
			q.offer(21);
			q.offer(37);
			
			q.addFirst(10);
			q.addLast(99);
			
			assertEquals(10, q.getFirst());
			assertEquals(99, q.getLast());
		}
	}
}
