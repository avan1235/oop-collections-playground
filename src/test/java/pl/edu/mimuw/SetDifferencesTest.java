package pl.edu.mimuw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SetDifferencesTest {
    @Nested
    class DifferenceInIterationOrder {

        @Test
        void iterateTreeSet() {
            Set<Integer> s = new TreeSet<>((l, r) -> r - l);
            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();

            assertEquals(3, it.next());
            assertEquals(2, it.next());
            assertEquals(1, it.next());
        }

        @Test
        void iterateHashSet() {
            Set<Integer> s = new HashSet<>();
            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();

            assertEquals(1, it.next());
            assertEquals(2, it.next());
            assertEquals(3, it.next());
        }

        @Test
        void iterateLinkedHashSet() {
            Set<Integer> s = new LinkedHashSet<>();

            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();

            assertEquals(2, it.next());
            assertEquals(1, it.next());
            assertEquals(3, it.next());
        }

    }

    @Nested
    class DifferenceInAddRemove {
        @Test
        void addRemoveInTreeSet() {
            Set<Integer> s = new TreeSet<>();
            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();
            int first = it.next();
            s.remove(first);
            s.add(first);
            it = s.iterator();
            int newfirst = it.next();
            assertEquals(first, newfirst);
        }

        @Test
        void addRemoveInHashSet() {
            Set<Integer> s = new HashSet<>();
            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();
            int first = it.next();
            s.remove(first);
            s.add(first);
            it = s.iterator();
            int newfirst = it.next();
            assertEquals(first, newfirst);
        }

        @Test
        void addRemoveInLinkedHashSet() {
            Set<Integer> s = new LinkedHashSet<>();

            s.add(2);
            s.add(1);
            s.add(3);
            Iterator<Integer> it = s.iterator();
            int first = it.next();
            s.remove(first);
            s.add(first);
            it = s.iterator();
            int newfirst = it.next();
            assertNotEquals(first, newfirst);
        }
    }

    @Nested
    class DifferenceInMethods {
        @Test
        void addRemoveInTreeSet() {
            SortedSet<Integer> s = new TreeSet<>();
            s.add(2);
            s.add(1);
            s.add(3);
            SortedSet<Integer> newSet = s.subSet(1, 2);
            assertEquals(1, newSet.size());
        }
    }
}
