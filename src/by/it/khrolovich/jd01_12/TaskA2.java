package by.it.khrolovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6};
        Integer[] valuesForTreeSet = {4, 4, 5, 5, 3, 4, 5, 5, 6, 6};
        //new HashSet<Integer>(Arrays.asList(1,1,2,2,3,4,5,5,6,6));//тоже самое


        Set<Integer> hashSet = new HashSet<>(Arrays.asList(valuesForHashSet));//capasity - степень 2-ки, например, 1024
        Set<Integer> treeSet = new HashSet<>(Arrays.asList(valuesForHashSet));
        System.out.println(hashSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(treeSet);

        Set<Integer> cross = getCross(hashSet, treeSet);
    }
    static  Set<Integer> getUnion(Set<Integer> a,Set<Integer> b){
       /* a.addAll(b);
        return a;*/
        HashSet<Integer> resultSet = new HashSet<>(a);//быстрее всего(быстрее чем TreeSet)
        resultSet.addAll(b);
        return resultSet;
    }

    static  Set<Integer> getCross(Set<Integer> a,Set<Integer> b){

        HashSet<Integer> resultSet = new HashSet<>(a);//быстрее всего(быстрее чем TreeSet)
        resultSet.retainAll(b);//TODO посмотреть как работает
        return resultSet;
    }
}