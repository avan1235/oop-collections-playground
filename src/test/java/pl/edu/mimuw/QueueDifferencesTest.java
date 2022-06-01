package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

class QueueDifferencesTest {

  @Nested
  class DifferencesInIterationOrder {
    @Test
    void iterateArrayDequeue() {
      var q = new ArrayDeque<>(List.of(1, 3, 2, 4));
      var z = new ArrayList<>(q);
      assertEquals(List.of(1, 3, 2, 4), z);
    }

    @Test
    void iterateLinkedList() {
      Queue<Integer> q = new LinkedList<>(List.of(1, 3, 2, 4));
      var z = new ArrayList<>(q);
      assertEquals(List.of(1, 3, 2, 4), z);
    }

    @Test
    void iteratePriorityQueue() {
      var q = new PriorityQueue<>(List.of(1, 3, -1, 2, 4));
      var z = new ArrayList<>(q);
      z.sort(Integer::compare); // No order guaranteed.
      assertEquals(List.of(-1, 1, 2, 3, 4), z);
    }
  }

  @Nested
  class DifferencesInPeek {
    @Test
    void peekArrayDequeue() {
      var q = new ArrayDeque<>(List.of(1, 3, 2, 4));
      assertEquals(1, q.peek());
    }

    @Test
    void peekLinkedList() {
      Queue<Integer> q = new LinkedList<>(List.of(1, 3, 2, 4));
      assertEquals(1, q.peek());
    }

    @Test
    void peekPriorityQueue() {
      var q = new PriorityQueue<>(List.of(1, 3, -1, 2, 4));
      assertEquals(-1, q.peek());
    }
  }

  @Nested
  class DifferencesInMethods {
    @Test
    void useArrayDequeueMethods() {
      var q = new ArrayDeque<>(List.of(1, 3, 2, 4));
      assertEquals(1, q.getFirst());
      assertEquals(4, q.getLast());
    }

    @Test
    void useLinkedListMethods() {
      var q = new LinkedList<>(List.of(1, 3, 2, 4));
      assertEquals(1, q.getFirst());
      assertEquals(4, q.getLast());
    }

    @Test
    void usePriorityQueueMethods() {
      var q = new PriorityQueue<>(List.of(1, 3, -1, 2, 4));
      // No method to get first and last element.
    }
  }
}
