package binarysearch;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by jamal on 8/4/18.
 */
public class TwoSum2 {

    /**
     * Solution Fails at duplicate values.
     *
     * @param args
     */
    public static void main(String[] args) {

        TwoSum2 twoSum2 = new TwoSum2();

        System.out.println(Arrays.toString(twoSum2.twoSum(new int[]{0, 0, 3, 4}, 0)));

    }

    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> valueVsIndex = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];

            if (valueVsIndex.containsKey(tmp) && valueVsIndex.get(tmp) != i) {
                return new int[]{valueVsIndex.get(tmp) + 1, i + 1};
            } else if (!valueVsIndex.containsKey(tmp)) {
                valueVsIndex.put(numbers[i], i);
            }
        }

        return null;
    }
}