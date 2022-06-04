package pl.edu.mimuw;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueueDifferencesTest {
  @Nested class OrderDifferences {
    @Test
    void inDeque() {
      Queue<String> q = new ArrayDeque<>();

      q.offer("pierwszy");
      q.offer("drugi");
      q.offer("trzeci");
      q.offer("czwarty");

      assertEquals("pierwszy", q.poll());
      assertEquals("drugi", q.poll());
      assertEquals("trzeci", q.poll());
      assertEquals("czwarty", q.poll());

    }
    @Test
    void inLinkedList() {
      Queue<String> q = new LinkedList<>();

      q.offer("pierwszy");
      q.offer("drugi");
      q.offer("trzeci");
      q.offer("czwarty");

      assertEquals("pierwszy", q.poll());
      assertEquals("drugi", q.poll());
      assertEquals("trzeci", q.poll());
      assertEquals("czwarty", q.poll());
    }
    @Test
    void inPriority() {
      Queue<String> q = new PriorityQueue<>();

      q.offer("pierwszy");
      q.offer("drugi");
      q.offer("trzeci");
      q.offer("czwarty");

      assertEquals("czwarty", q.poll());
      assertEquals("drugi", q.poll());
      assertEquals("pierwszy", q.poll());
      assertEquals("trzeci", q.poll());
    }
  }

  @Nested class NullPointerDifferences {
    @Test
    void inDeque() {
      Queue<String> q = new ArrayDeque<>();

      assertThrows(NullPointerException.class, () -> q.add(null));

    }
    @Test
    void inLinkedList() {
      Queue<String> q = new LinkedList<>();

      assertEquals(true, q.add(null));
    }
    @Test
    void inPriority() {
      Queue<String> q = new PriorityQueue<>();

      assertThrows(NullPointerException.class, () -> q.add(null));
    }
  }

  @Nested class AddingDifferences {
    @Test
    void inDeque() {
      ArrayDeque<String> q = new ArrayDeque<>();

      q.addFirst("pierwszy");
      q.add("drugi");
      q.addLast("trzeci");

      assertEquals("pierwszy", q.poll());
      assertEquals("drugi", q.poll());
      assertEquals("trzeci", q.poll());

    }
    @Test
    void inLinkedList() {
      LinkedList<String> q = new LinkedList<>();

      q.addFirst("pierwszy");
      q.add("drugi");
      q.addLast("trzeci");

      assertEquals("pierwszy", q.poll());
      assertEquals("drugi", q.poll());
      assertEquals("trzeci", q.poll());
    }
    @Test
    void inPriority() {
      Queue<String> q = new PriorityQueue<>();

      q.offer("pierwszy");
      q.offer("drugi");
      q.offer("trzeci");

      assertEquals("drugi", q.poll());
      assertEquals("pierwszy", q.poll());
      assertEquals("trzeci", q.poll());
    }
  }

}
