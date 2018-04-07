package amazon;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RearrangeNumber {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();


        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfArrayElements = scanner.nextInt();
            int[] array = new int[numberOfArrayElements];

            for (int k = 0; k < array.length; k++) {
                array[k] = scanner.nextInt();
            }

            Set<Integer> findDup = new HashSet<>();

            int duplicateNumber = -1;
            for (int j = 0; j < array.length; j++) {
                if (findDup.contains(array[j])) {
                    duplicateNumber = array[j];
                    break;
                } else {
                    findDup.add(array[j]);
                }
            }
            int[] newArray = new int[array.length];
            Arrays.fill(newArray, 1);

            int newArrayIndex = array.length - 1;
            for (int k = array.length - 1; k >= 0; k--) {
                if (array[k] != duplicateNumber) {
                    newArray[newArrayIndex] = array[k];
                    newArrayIndex++;
                }
            }

            for (int k = 0; k < newArray.length; k++) {
                System.out.print(newArrayIndex);
            }

        }

    }
}
