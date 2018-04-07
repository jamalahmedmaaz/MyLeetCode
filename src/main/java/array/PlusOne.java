package array;

import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int array[] = {7,
                2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};

        StringBuilder s = new StringBuilder();
        for (int anArray : array) {
            s.append(anArray);
        }
        BigInteger a = new BigInteger(s.toString());
        String result = String.valueOf(a.add(BigInteger.ONE));

        int tmp[] = new int[result.length()];

        for (int i = 0; i < result.length(); i++) {
            tmp[i] = result.charAt(i) - '0';
        }

        System.out.println(Arrays.toString(tmp));
    }
}
