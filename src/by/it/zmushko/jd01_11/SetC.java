package by.it.zmushko.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private E[] elem = (E[]) new Object[0];
    private int size;

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            join.add(String.valueOf(elem[i]));
        }
        return join.toString();
    }

    @Override
    public boolean add(E e) {
        //сразу проверка на размер
        if (size == elem.length) {
            elem = Arrays.copyOf(elem, elem.length * 3 / 2 + 1);
        }
        //проверка на вхождение в множество
        for (int i = 0; i < elem.length; i++) {
            if (!Arrays.asList(elem).contains(e)) {
                elem[size++] = e;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elem[i] == o) {
                System.arraycopy(elem, i + 1, elem, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elem[i] == o) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (Arrays.asList(elem).contains(o)) ;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Arrays.asList(elem).clear();
        return true;
    }

    //дальше не лезть
    @SuppressWarnings("ConstantConditions")
    @Override
    public Iterator<E> iterator() {
        return null;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
