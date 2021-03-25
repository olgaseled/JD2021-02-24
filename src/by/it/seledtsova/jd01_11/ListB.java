package by.it.seledtsova.jd01_11;

import java.util.*;

public class ListB <T> implements List <T>  {
    private T[] elements= (T[]) new Object[]{};  // создали приватное поле в котором будет храниться элементы массива
    private int size=0;                  // типа Т с названием elements. Заполним его новым массивом Obgect. и укажем,
    // что нам массив будет нулевой длинны и скастим его к типу Т. длинна будет увеличиватся по мере добавления элементов
    //size - хранится наш размер. Первоначально 0

    @Override
    public boolean add(T t) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1); //увеличиваетсч на 1,5. после этом формулы хоть один элемент есть
        elements[size++]=t;
        return false;
    }

    @Override
    public T remove(int index) {
        T del= elements [index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;
        return del;
    }
    @Override
    public T set(int index, T element) {
        T returnElements=elements[index];
        elements[index] = element;
        return returnElements;

    }

    @Override
    public T get(int index) {
        return elements [index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("[");
        String delimeter="";
        for (int i = 0; i < size; i++) { // двигаться будем д размера

            stringBuilder.append(delimeter).append(elements[i]); //
            delimeter = ", ";
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }



    @Override
    public void add(int index, T element) { // должен раздвигать значения массива и при необходимости его увеличивать
        if (size==elements.length)
            elements= Arrays.copyOf(elements,(size*3)/2+1); // копирует из массива элементы с указанной позиции на след позицию
        System.arraycopy(elements,index,elements,index+1,size-index); // указать на какую доинну он копирует
        elements[index]=element;
        size++;
    }

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
    public boolean remove(Object o) {
        int index=indexOf(o);
        if (index>-1) remove(index);
        return index>-1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override

    public boolean addAll(Collection<? extends T> c) {
        T[] ArrayList = (T[]) c.toArray();
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (elements.length * 3 )/ 2 + 1);
        }
        elements = Arrays.copyOf(elements, elements.length + ArrayList.length + 1);
        System.arraycopy(ArrayList, 0, elements, size, ArrayList.length);
        size += ArrayList.length;
        return true;
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
    public int indexOf(Object o) { // для коректной работы remove по обьекту нужно реализовать
        if (o==null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null) // объектом м.б любо null. Если это Null,
                    return i; //то нужно перебирать все элементы и как только натолкнулись на null возвращать i
        } else {
            for (int i = 0; i < size; i++) // иначе перебираемся все элементы и  сравниваемся их по equals.
                if (o.equals(elements[i]))
                    return i;

        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

