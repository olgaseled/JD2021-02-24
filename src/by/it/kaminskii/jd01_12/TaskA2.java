package by.it.kaminskii.jd01_12;/* created by Kaminskii Ivan
 */

import java.util.*;

public class TaskA2 {
    private static Set<Integer> getUnion(Set<Integer>one,Set<Integer>two){
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }
    private static Set<Integer> getCross(Set<Integer>one,Set<Integer>two){
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
    public static void main(String[] args) {
        HashSet<Integer> hashSet= new HashSet<>(Arrays.asList(1,2,2,3,4,1,2,2,3,4,5,6));
        TreeSet<Integer> treeSet= new TreeSet<>(Arrays.asList(9,2,2,3,4,1,2,2,3,8,8,6));

        System.out.println(getUnion(hashSet,treeSet));
        System.out.println(getCross(hashSet,treeSet));
    }
}
