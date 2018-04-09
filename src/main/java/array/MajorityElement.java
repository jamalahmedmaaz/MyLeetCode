package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{1, 1, 1, 1, 2, 3, 4}));
        System.out.println(majorityElement.majorityElement(new int[]{1, 2, 3, 45, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 66, 3}));
    }


    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }


        for (Map.Entry<Integer, Integer> instance : map.entrySet()) {
            if (instance.getValue() > nums.length / 2) {
                return instance.getKey();
            }
        }

        return -1;
    }


    /**
     * Another Solution.
     **/

    public int majorityElement__1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        //Very interesting solution

        return nums[nums.length / 2];
    }
}
