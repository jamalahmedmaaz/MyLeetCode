package google;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {

    public static final int INDEX = 0;

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdab"));
    }

    /**
     * Idea 1
     * <p>
     * instead of adding A multiple times to itself to find B.
     * <p>
     * Lets try to remove (or only compare) A from B, in sequential manner.
     *
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {

        if (A.length() > B.length()) {
            String tmp = A;
            A = B;
            B = tmp;
        }

        int counter = 0;
        for (int i = 0; i < B.length(); i++) {
            int INDEX = 0;
            if (i == 0) {
                INDEX = findFirstIntersection(A, B);
                if (INDEX == -1) {
                    return INDEX;
                }
            } else {
                INDEX = 0;
            }
            if (B.charAt(i) == A.charAt(INDEX)) {
                for (int j = INDEX, tmp = i; j < A.length() && tmp < B.length();
                     j++, tmp++) {
                    if (B.charAt(tmp) != A.charAt(j)) {
                        return -1;
                    }

                }
                counter++;
            }
        }

        if (counter == 0 && (A.length() > 0 || B.length() > 0)) {
            return -1;
        }
        return counter;
    }

    private int findFirstIntersection(String a, String b) {
        char c = b.charAt(0);
        for (int i = 0; i < a.length(); i++) {
            if (c == a.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
