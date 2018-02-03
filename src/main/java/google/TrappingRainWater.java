package google;

/**
 * Time limit exceeded for one test case
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{9, 8, 2, 6}));
    }

    public int trap(int[] height) {

        int totalNumberOfSlots = Integer.MIN_VALUE;

        for (int i : height) {
            if (i > totalNumberOfSlots)
                totalNumberOfSlots = i;
        }

        int trapSlotOfWater = 0;

        while (totalNumberOfSlots != 0) {

            int start = -1;
            int counter = 0;
            boolean availableSlot = false;

            for (int i = 0; i < height.length; i++) {
                if (start == -1 && height[i] > 0) {
                    start = i;
                } else {
                    if (start != -1 && height[i] > 0 && availableSlot) {
                        counter = counter + (i - start) - 1;
                        start = -1;
                        availableSlot = false;
                    }
                    if (height[i] == 0 && start != -1) {
                        availableSlot = true;
                    }

                    if (!availableSlot && height[i] > 0) {
                        start = i;
                    }
                }
                if (height[i] > 0) {
                    height[i] = height[i] - 1;
                }

            }


            trapSlotOfWater = trapSlotOfWater + counter;

            totalNumberOfSlots = totalNumberOfSlots - 1;
        }
        return trapSlotOfWater;
    }
}
