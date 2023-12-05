package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Exercise15 {
    public static void main(String[] args) {
        List<Integer> integers = new ListNoStorage(0, 500);
        List<Integer> subList = integers.subList(250, 280);
        System.out.println(subList);
        System.out.println(integers);
    }

    private static class ListNoStorage implements List<Integer> {

        Integer n;
        Integer s;

        public ListNoStorage(Integer s, Integer n) {
            this.n = n;
            this.s = s;
        }

        @Override
        public String toString() {
            return new ArrayList<>(this).toString();
        }

        @Override
        public int size() {
            return n;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return ((Integer) o) <= n;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int current = s;

                @Override
                public boolean hasNext() {
                    return current < n;
                }

                @Override
                public Integer next() {
                    return current++;
                }
            };
        }

        @Override
        public Object[] toArray() {
            Integer[] ints = new Integer[n - s];
            for (int i = s; i < n; i++)
                ints[i - s] = i;
            return ints;
        }

        @Override
        public <T> T[] toArray(T[] a) {
            for (int i = s; i < n; i++)
                a[i - s] = (T) (Integer) i;
            return a;
        }

        @Override
        public boolean add(Integer integer) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Integer get(int index) {
            return index;
        }

        @Override
        public Integer set(int index, Integer element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int index, Integer element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Integer remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(Object o) {
            if (o instanceof Integer integer)
                return integer;
            else
                throw new IllegalArgumentException();
        }

        @Override
        public int lastIndexOf(Object o) {
            return indexOf(o);
        }

        @Override
        public ListIterator<Integer> listIterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return new ListNoStorage(fromIndex, toIndex);
        }
    }
}
