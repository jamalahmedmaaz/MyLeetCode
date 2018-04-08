package uber;

import java.util.*;

public class Trips {


    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println(Arrays.toString(getMarkers()));

        getResult(n);
    }

    private static int getResult(int n) {
        TreeSet<Integer> runtimeOfCab = new TreeSet<>();

        runtimeOfCab.add(2);
        runtimeOfCab.add(1);


        SortedArrayList<Integer> activeCabs = new SortedArrayList<>();

        int counter = 1;

        for (; n > 0; ) {

            if (counter == 1) {
                n = n - runtimeOfCab.size();
                activeCabs.addAll(runtimeOfCab);
            } else {
                int in = reverseOrder(activeCabs, counter);
                if (in > 0) {
                    for (int i = 0; i < in; i++) {
                        n = n - 1;
                    }
                    counter = counter / in;
                }
            }
            counter++;
        }

        return counter - 1;
    }

    private static int reverseOrder(SortedArrayList<Integer> activeCabs, int counter) {


        for (int i = activeCabs.size() - 1; i >= 0; i++) {
            if (counter >= activeCabs.get(i)) {
                return i;
            }
        }
        return 0;
    }


    private static int[] getMarkers() {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        map.put(-1, 0);
        map.put(3, 6);
        map.put(4, 9);


        for (Map.Entry<Integer, Integer> instance : map.entrySet()) {
            int key = instance.getKey();
            int value = instance.getValue();

            for (int i = key; i <= value; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                }
            }
        }
        int[] i = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(i);
        return i;
    }
}


class SortedArrayList<T> extends ArrayList<T> {

    @SuppressWarnings("unchecked")
    public void insertSorted(T value) {
        add(value);
        Comparable<T> cmp = (Comparable<T>) value;
        for (int i = size() - 1; i > 0 && cmp.compareTo(get(i - 1)) < 0; i--)
            Collections.swap(this, i, i - 1);
    }
}