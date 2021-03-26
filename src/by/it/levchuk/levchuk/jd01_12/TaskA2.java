package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import com.sun.source.doctree.SeeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1,1,2,2,3,4,5,5,6,6};
        Integer[] valuesForTreeSet = {14,4,5,5,6,7,8,8,9,9,99};
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(valuesForHashSet));
        Set<Integer> treeSet = new HashSet<>(Arrays.asList(valuesForTreeSet));
        System.out.println(hashSet);
        //Set<Integer> union = getUnion(hashSet,treeSet);
        //System.out.println(union);
    }
}
