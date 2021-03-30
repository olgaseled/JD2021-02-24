package by.it.papruga.jd01_12;

import java.util.*;

public class TaskA2 {


   private static Set<Integer> getUnion (Set<Integer>one, Set<Integer>two)
    {

        HashSet <Integer> result = new HashSet<>(one);
        Iterator <Integer> twoIterator = two.iterator();
        while (twoIterator.hasNext())
        {
            int temp = twoIterator.next();
            result.add(temp);
        }

        return result;

    }

   private static Set<Integer> getCross (Set<Integer>one, Set<Integer>two)
   {
       HashSet <Integer> result = new HashSet<>();
       Iterator <Integer> twoIterator = two.iterator();

       while (twoIterator.hasNext())
       {
           int temp = twoIterator.next();
           if (one.contains(temp))
               result.add(temp);
       }

       return result;



  }





    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>(Arrays.asList(1,2,3,4,4,4,5,5,6,6));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(9,8,7,4,4,4,5,5,6,6));


        System.out.println(getCross(hashSet,treeSet));
        System.out.println(getUnion(hashSet,treeSet));

    }


}
