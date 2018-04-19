package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DegreeofanArray {

    public static void main(String[] args) {
        DegreeofanArray degreeofanArray = new DegreeofanArray();
        System.out.println(degreeofanArray.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

    public int findShortestSubArray(int[] nums) {

        PriorityQueue<MyDS> el = new PriorityQueue<MyDS>((e1, e2) -> e1.count - e2.count);
        if (nums == null) {
            return 0;
        }

        HashMap<Integer, MyDS> ints = new HashMap<>();

        int largestCount = 0;
        for (int i = 0; i < nums.length; i++) {

            int currentNumber = nums[i];
            if (ints.containsKey(currentNumber)) {
                MyDS ds = ints.get(currentNumber);
                ds.setCount(ds.getCount() + 1);
                ds.setEndIndex(i);

                ints.put(currentNumber, ds);
            } else {
                MyDS ds = new MyDS();
                ds.setStartIndex(i);
                ds.setEndIndex(-1);
                ds.setCount(1);
                ints.put(currentNumber, ds);
            }

            largestCount = Math.max(largestCount, ints.get(currentNumber).getCount());

        }

        int findLowestSubArrayCount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, MyDS> instance : ints.entrySet()) {
            if (instance.getValue().getCount() == largestCount) {
                findLowestSubArrayCount = Math.min(instance.getValue().getDifference(), findLowestSubArrayCount);
            }
        }


        return findLowestSubArrayCount;
    }

    class MyDS {
        int startIndex;
        int endIndex;
        int count;
        private int difference;


        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getDifference() {
            if (endIndex == -1) {
                return 1;
            }
            return Math.abs(startIndex - endIndex) + 1;
        }

        public void setDifference(int difference) {
            this.difference = difference;
        }
    }


}
