package by.it.kirichenko.jd01_11;

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
        E returnValue = elements[index];
        elements[index] = element;
        return returnValue;
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        E resultElements[] = Arrays.copyOf(elements, elements.length);

        //вставляем в результат массив слева от индекса
        System.arraycopy(elements, 0, resultElements, 0, index);

        //вставляем в результат сам элемент
        resultElements[index] = element;

        //вставляем в результат массив справа от индекса
        System.arraycopy(elements, index, resultElements, index + 1, size - index);

        elements = Arrays.copyOf(resultElements, resultElements.length);

        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int newsize = size + c.size();
        if (elements.length < newsize) {
            elements = Arrays.copyOf(elements, newsize * 3 / 2 + 1);
        }
        System.arraycopy(c.toArray(), 0, elements, size, c.size());
        size = newsize;
        return true;
    }

    @Override
    public String toString() {
        StringJoiner txt = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                txt.add(elements[i].toString());
            }
            else{
                txt.add("null");
            }
        }
        return txt.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    // ---- stubs -----

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
