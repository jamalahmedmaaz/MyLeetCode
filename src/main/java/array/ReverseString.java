package array;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        System.out.println(reverseString.reverseString_onemore("jamal"));
    }

    public String reverseString_onemore(String s) {

        char[] current = s.toCharArray();
        char[] result = new char[current.length];

        int size = current.length;

        for (int i = 0; i < current.length; i++) {
            result[i] = current[size - i - 1];
        }


        return new String(result);
    }
}
