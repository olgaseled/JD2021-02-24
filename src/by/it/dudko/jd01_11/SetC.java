package by.it.dudko.jd01_11;

import java.util.*;

@SuppressWarnings("unused")
public class SetC<T> implements Set<T> {
    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[0];

    private int size;

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (int index = 0; index < size; index++) {
            joiner.add(String.valueOf(elements[index]));
        }
        return joiner.toString();
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        if (size == elements.length) {
            extendCapacity();
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(o, elements[index])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(o, elements[index])) {
                System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int sizeBefore = size;
        for (T t : c) {
            if (contains(t)) continue;
            add(t);
        }
        return !c.isEmpty() && sizeBefore < size;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return c.size() != 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int sizeBefore = size;
        for (int index = 0; index < size; index++) {
            for (Object o : c) {
                if (Objects.equals(o, elements[index])) {
                    System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
                    elements[--size] = null;
                }
            }
        }
        return size < sizeBefore;
    }

    @Override
    public void clear() {
        //noinspection unchecked
        elements = (T[]) new Object[0];
        size = 0;
    }

    private void extendCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
    }

    @Override
    public Iterator<T> iterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        //noinspection ConstantConditions
        return null;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
