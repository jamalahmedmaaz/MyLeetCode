package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KeyboardRow {
    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        System.out.println(Arrays.toString(keyboardRow.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public String[] findWords(String[] words) {
        HashSet<Character> line1 = new HashSet(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        HashSet<Character> line2 = new HashSet(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        HashSet<Character> line3 = new HashSet(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M', 'z', 'x', 'c', 'v', 'b', 'n', 'm'));


        List<String> ss = new ArrayList<>();
        for (String s : words) {
            List<Character> l = new ArrayList<>();
            for (Character c : s.toCharArray()) {
                l.add(c);
            }

            if (line1.containsAll(l)) {
                ss.add(s);
            }
            if (line2.containsAll(l)) {
                ss.add(s);
            }
            if (line3.containsAll(l)) {
                ss.add(s);
            }
        }

        String[] res = new String[ss.size()];
        res = ss.toArray(res);

        return res;
    }
}
