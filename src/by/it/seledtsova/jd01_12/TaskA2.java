package by.it.seledtsova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {


    public static void main(String[] args) {
        TaskA2 taskA2 = new TaskA2();
        Integer [] valueForHashSet= {1,1,2,2,3,4,5,5,6,6};
        Integer [] valueForTreeSet= {4,4,5,5,6,7,8,8};

        Set<Integer> hashSet=new HashSet<>(Arrays.asList(valueForHashSet));
        Set<Integer> treeSet=new HashSet<>(Arrays.asList(valueForTreeSet));
        System.out.println(hashSet);
        System.out.println(treeSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(union);
            }

private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) { // пересечение множеств
        HashSet<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        return result;
}

private static Set<Integer> getUnion (Set<Integer> a, Set<Integer> b) { //объединение множеств
        HashSet<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;

    }
/*

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }
 */

}
