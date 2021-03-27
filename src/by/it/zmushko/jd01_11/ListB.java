package by.it.zmushko.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elem = (T[]) new Object[0];
    private int size;

    @Override
    public String toString() {
        StringJoiner text = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            text.add(String.valueOf(elem[i]));
        }
        return text.toString();
    }

    @Override
    public boolean add(T t) {
        if (size == elem.length) { //если косяк с размером массива, копируем и увеличиваем размер
            elem = Arrays.copyOf(elem, elem.length * 3 / 2 + 1); //универсальная формула увеличения массива
        }
        elem[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T element) { //[1,2,3, (4) ,5 ,6 ,7 ,8 ,9]
        T[] temp = null;
        if (size == elem.length) {
            elem = Arrays.copyOf(elem, elem.length * 3 / 2 + 1);
        }
        size++;
        System.arraycopy(elem, index, elem, index + 1, size - index);
        elem[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean check = false;
        for (T t : c) {
            this.add(t);
            check = true;
        }
        return check;
    }

    @Override
    public T remove(int index) {
        T returnValue = elem[index]; //возврат удаляемого эл=та
        System.arraycopy(elem, index + 1, elem, index, size - index - 1);
        elem[--size] = null;
        return returnValue;
    }

    @Override
    public T get(int index) {
        T returnValue = elem[index];
        return returnValue;
    }

    @Override
    public T set(int index, T element) {
        T returnValue = elem[index];
        elem[index] = element;
        return returnValue;
    }

    // Дальше не лезь
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
        for (int i = 0; i < elem.length; i++) {
            if (elem[i] == o) {
                return i+1;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
