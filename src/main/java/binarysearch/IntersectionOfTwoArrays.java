package binarysearch;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jamal on 8/4/18.
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        //Food for thought, how would two table join in postgresql.

        //O(n) space and O(n) time
        Set<Integer> secondSet = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        int[] result = Arrays.stream(nums2).distinct().filter(secondSet::contains).toArray();

        System.out.println(Arrays.toString(result));


    }
}
