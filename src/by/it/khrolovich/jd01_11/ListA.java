package by.it.khrolovich.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListA<E> implements List<E> {

    //private E[] elements = (E[]) new Object[]{};//массив нулевого размера, приводим к типу Е
    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[0];//по умолчанию null

    private int size ;//сколько элеметов содержит

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            //получаем новый массив с новой длиной
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);//со сдвигом
            //если size 0, то newlength = 1
            //формула, которя эмпирически увеличивает массив
            //для представления, что происходит внутри коллекции

        }
        elements[size++] = e;//постинкремент: сначала присваивает, затем увеличиваем size
        return true;
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index -1);
        //size - index - 1 - длина кусочка
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
        //return  Arrays.toString(elements);//в конце остаются нулевые
        //обходим до размера массива, а не до elements.length
        for (int i=0;i<size;i++){
            //элемент может быть null, тогда не работает toString
            //stringJoiner.add(elements[i].toString());
            //stringJoiner.add(String.valueOf(elements[i]));
            stringJoiner.add((elements[i]==null)?"null":elements[i].toString());
        }
        //return super.toString();
        return stringJoiner.toString();
    }


    //----------stubs-------------

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public boolean remove(Object o) {
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

    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

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
    public boolean addAll(Collection<? extends E> c) {
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
    public E set(int index, E element) {
        return null;
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
