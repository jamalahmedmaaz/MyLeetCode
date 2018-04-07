package array;

import java.util.Arrays;

public class PascalsTraingle {
    public static void main(String[] args) {
        int array[] = {1, 1};

        for (int i = 1; i < 3; i++) {


            int[] tmp = new int[array.length + 1];
            tmp[0] = 1;
            int counter = 1;
            for (int i1 = 0; i1 < array.length - 1; i1++) {
                int processed = array[i1] + array[i1 + 1];
                tmp[counter] = processed;
                counter++;
            }

            tmp[counter] = 1;
            array = tmp;
        }


        System.out.println(Arrays.toString(array));

    }
}
