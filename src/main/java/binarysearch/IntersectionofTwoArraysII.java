package binarysearch;

import java.util.*;

public class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        IntersectionofTwoArraysII intersectionofTwoArraysII = new IntersectionofTwoArraysII();
        System.out.println(Arrays.toString(intersectionofTwoArraysII.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table1 = new HashMap<>();

        Map<Integer, Integer> table2 = new HashMap<>();


        for (int i = 0; i < nums1.length; i++) {
            if (table1.containsKey(nums1[i])) {
                table1.put(nums1[i], table1.get(nums1[i]) + 1);
            } else {
                table1.put(nums1[i], 1);
            }
        }


        for (int i = 0; i < nums2.length; i++) {
            if (table2.containsKey(nums2[i])) {
                table2.put(nums2[i], table2.get(nums2[i]) + 1);
            } else {
                table2.put(nums2[i], 1);
            }
        }

        List<Integer> integers = new ArrayList<>();

        for (Map.Entry<Integer, Integer> instance : table1.entrySet()) {
            if (table2.containsKey(instance.getKey())) {
                int number = Math.min(instance.getValue(), table2.get(instance.getKey()));
                for (int i = 0; i < number; i++) {
                    integers.add(instance.getKey());
                }
            }
        }

        return integers.stream().mapToInt(Integer::intValue).toArray();
    }
}