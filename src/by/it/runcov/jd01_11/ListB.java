package by.it.runcov.jd01_11;

import java.util.*;


public class ListB<E> implements List<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[0];
    private int size;

    @Override
    public boolean add(E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return returnValue;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = elements[index];
        elements[index] = element;
        return oldValue;
    }


    @Override
    public void add(int index, E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] otherList = (E[]) c.toArray();
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        for (int i = 0; i < c.size(); i++) {

        }
        elements = Arrays.copyOf(elements, elements.length + otherList.length + 1);
        System.arraycopy(otherList, 0, elements, size, otherList.length);
        size += otherList.length;
        return true;
    }

    @Override
    public String toString() {
        StringJoiner txt = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            txt.add(String.valueOf(elements[i]));
        }
        return txt.toString();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
