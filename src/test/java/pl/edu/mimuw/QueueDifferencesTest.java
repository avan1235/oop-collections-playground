package pl.edu.mimuw;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.NullPointerException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueDifferencesTest {

  @Nested
  class DifferenceInElementReturnOrder {

    /** ArrayDeque zwraca elementy w kolejności wstawiania. */
    @Test
    void returnFromArrayDeque() {
      Queue<Integer> q = new ArrayDeque<Integer>();
      q.add(2);
      q.add(1);
      q.add(3);

      assertEquals(2, q.poll());
      assertEquals(1, q.poll());
      assertEquals(3, q.poll());
    }

    /** LinkedList zwraca elementy w kolejności wstawiania. */
    @Test
    void returnFromLinkedList() {
      Queue<Integer> q = new LinkedList<Integer>();
      q.add(2);
      q.add(1);
      q.add(3);

      assertEquals(2, q.poll());
      assertEquals(1, q.poll());
      assertEquals(3, q.poll());
    }

    /** PriorityQueue zwraca elementy uporządkowane przez domyślny komparator. */
    @Test
    void returnFromPriorityQueue() {
      Queue<Integer> q = new PriorityQueue<Integer>();
      q.add(2);
      q.add(1);
      q.add(3);

      assertEquals(1, q.poll());
      assertEquals(2, q.poll());
      assertEquals(3, q.poll());
    }
  }

  @Nested
  class DifferenceInNullHandling {

    /** ArrayDeque nie przyjmuje argumentów typu null. */
    @Test
    void addNullToArrayDeque() {
      Queue<Integer> q = new ArrayDeque<Integer>();

      assertThrows(NullPointerException.class, () -> q.add(null));
    }

    /** LinkedList przyjmuje argumenty typu null. */
    @Test
    void addNullToLinkedList() {
      Queue<Integer> q = new LinkedList<Integer>();

      assertDoesNotThrow(() -> q.add(null));
    }

    /** PriorityQueue nie przyjmuje argumentów typu null. */
    @Test
    void addNullToPriorityQueue() {
      Queue<Integer> q = new PriorityQueue<Integer>();

      assertThrows(NullPointerException.class, () -> q.add(null));
    }
  }

  @Nested
  class DifferenceInMethods {

    /** ArrayDeque i Linked List mają metodę pozwalającą na wstawienie elementu na początku. */
    @Test
    void addOnBeginArrayDeque() {
      Deque<Integer> q = new ArrayDeque<Integer>();
      q.add(2);
      q.add(1);
      q.add(3);

      q.addFirst(4);

      assertEquals(4, q.peek());
    }

    @Test
    void addOnBeginLinkedList() {
      Deque<Integer> q = new LinkedList<Integer>();
      q.add(2);
      q.add(1);
      q.add(3);

      q.addFirst(4);

      assertEquals(4, q.peek());
    }
  }
}
