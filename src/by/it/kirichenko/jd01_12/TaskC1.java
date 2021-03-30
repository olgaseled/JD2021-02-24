package by.it.kirichenko.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indexMap=0;
        Map<Integer,String> map = new LinkedHashMap<>();
        Set<String> setUnigueValuesFromMap = new HashSet<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            map.put(indexMap,line.trim());
            indexMap++;
        }
        System.out.println(map);
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            if(!setUnigueValuesFromMap.add(entry.getValue())){
                iterator.remove();
            }
        }
        System.out.println(map);
    }

}
