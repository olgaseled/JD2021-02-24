package by.it.kirichenko.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[0];

    private int size;

    @Override
    public boolean add(E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        //добавить элемент, если его еще нет в множестве
        if (indexOf(element) == -1) {
            elements[size++] = element;
        }
        return true;
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
    public boolean contains(Object value) {
        return Arrays.asList(elements).contains(value);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] inArr = (E[]) Arrays.copyOf(c.toArray(), c.size());
        E[] inArrNotNullAndUnical = (E[]) Arrays.copyOf(c.toArray(), c.size());

        // E inArrNotNullAndUnical = (E) Arrays.copyOf(c.toArray(), c.size());

        for (int i = 0; i < inArrNotNullAndUnical.length; i++) {
            inArrNotNullAndUnical[i] = null;
        }
        int newSizeinArrNotNull = 0;
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] != null && indexOf(inArr[i]) == -1) {
                inArrNotNullAndUnical[newSizeinArrNotNull++] = inArr[i];
            }
        }

        int newsize = size + newSizeinArrNotNull;
        if (elements.length < newsize) {
            elements = Arrays.copyOf(elements, newsize * 3 / 2 + 1);
        }
        System.arraycopy(inArrNotNullAndUnical, 0, elements, size, newSizeinArrNotNull);
        size = newsize;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean contains;
        if (collection.isEmpty()) {
            contains = false;
        } else {
            contains = true;
        }
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                contains = false;
            }
        }
        return contains;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removeYes = false;
        Iterator<?> iterator = collection.iterator();
        int indexElement;
        while (iterator.hasNext()) {
            indexElement = indexOf(iterator.next());
            if (indexElement != -1) {
                removeElement(indexElement);
                removeYes = true;
            }
        }
        return removeYes;
    }

    public E removeElement(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return returnValue;
    }

    public int indexOf(Object value) {
        int index = -1;

        if (value==null){
            return index;
        }

        String elementStr;
        String valueStr;
        for (int i = 0; i < size; i++) {
            elementStr=elements[i].toString();
            valueStr=value.toString();
            if (elementStr.equals(valueStr)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public String toString() {
        StringJoiner txt = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                txt.add(elements[i].toString());
            } else {
                txt.add("null");
            }
        }
        return txt.toString();
    }

    // ---- stubs -----

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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
