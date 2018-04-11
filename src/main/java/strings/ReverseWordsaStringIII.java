package strings;

public class ReverseWordsaStringIII {
    public static void main(String[] args) {
        ReverseWordsaStringIII reverseWordsaStringIII = new ReverseWordsaStringIII();
        System.out.println("Let's take LeetCode contest");
        System.out.println(reverseWordsaStringIII.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        char[] result = new char[charArray.length];
        int cut = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                int cutTmp = cut;
                for (int j = i - 1; cut <= j; j--) {
                    result[cutTmp] = charArray[j];
                    cutTmp++;
                }
                if (charArray.length - 1 != i)
                    result[i] = ' ';
                cut = i + 1;
            }

            if (charArray.length - 1 == i) {
                int cutTmp = cut;
                for (int j = i; cut <= j; j--) {
                    result[cutTmp] = charArray[j];
                    cutTmp++;
                }
            }
        }

        return String.valueOf(result);
    }

}
