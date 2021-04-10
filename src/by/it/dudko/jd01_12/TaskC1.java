package by.it.dudko.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {

        Map<Integer, String> objects = buildMapFromUserInput();
        System.out.println(objects.toString());
        collapseRepeatingValues(objects);
        System.out.println(objects.toString());
    }

    private static Map<Integer, String> buildMapFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> objects = new TreeMap<>();
        String objName;
        int code, index = 0;
        while (!(objName = scanner.nextLine().trim()).equals("end")) {
            index++;
            code = String.valueOf(index).concat(objName).hashCode();
            objects.put(code, objName);
        }
        return objects;
    }

    @SuppressWarnings("Java8CollectionRemoveIf")
    private static void collapseRepeatingValues(Map<Integer, String> objects) {
        Map<String, Integer> swappedMap = swapMap(objects);
        // swappedMap have to be swapped again
        Map<Integer, String> filteredMap = swapMap(swappedMap);
        // now remove all the original entries that do not match with filtered map entries
        Iterator<Map.Entry<Integer, String>> iterator = objects.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> objectsEntry = iterator.next();
            if (!(filteredMap.containsKey(objectsEntry.getKey()))) {
                iterator.remove();
            }
        }
    }

    private static <T1, T2> Map<T2, T1> swapMap(Map<T1, T2> objects) {
        Map<T2, T1> swappedMap = new LinkedHashMap<>(); // order is matters
        List<Map.Entry<T1, T2>> objEntrySet = new ArrayList<>(objects.entrySet());
        // Iterate backward to provide copying to LinkedHashMap only the first occurred entry
        for (int i = objEntrySet.size() - 1; i >= 0; i--) {
            Map.Entry<T1, T2> bufferEntry = objEntrySet.get(i);
            // do swap (and get collapsing from HashMap for free!)
            swappedMap.put(bufferEntry.getValue(), bufferEntry.getKey());
        }
        return swappedMap;
    }

}
