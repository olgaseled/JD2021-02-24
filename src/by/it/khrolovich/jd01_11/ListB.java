package by.it.khrolovich.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<E> implements List<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[0];//по умолчанию null

    private int size;//сколько элеметов содержит

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);//со сдвигом
        }
        elements[size++] = e;
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
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {

            stringJoiner.add((elements[i] == null) ? "null" : elements[i].toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);//со сдвигом
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;

    }

    @Override
    public E set(int index, E element) {
        E delItem = elements[index];
        elements[index] = element;
        return delItem;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            this.add(element);
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<>() {
            private int current = -1;

            @Override
            public boolean hasNext() {
                return current + 1 < size;
            }

            @Override
            public E next() {
                return elements[current + 1];
            }

            @Override
            public void remove() {
                //удаляем текущий элемент, метож remove уже есть
                ListB.this.remove(current);
            }
        };
    }
    //----------stubs-------------


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }




    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
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
