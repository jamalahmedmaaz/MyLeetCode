package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamal on 8/4/18.
 */
public class JudgeRouteCircle {

    public static void main(String[] args) {
        String moves = "LDRRLRUULR";

        System.out.println(circle(moves));

    }

    private static boolean circle(String moves) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();

        for (int i = 0; i < moves.length(); i++) {
            if (characterIntegerHashMap.containsKey(moves.charAt(i))) {
                characterIntegerHashMap.put(moves.charAt(i), characterIntegerHashMap.get(moves.charAt(i)) + 1);
            } else {
                characterIntegerHashMap.put(moves.charAt(i), 1);
            }
        }

        int totalVertical = 0;
        int totalHorizontal = 0;
        for (Map.Entry<Character, Integer> instance : characterIntegerHashMap.entrySet()) {
            switch (instance.getKey()) {
                case 'U':
                    totalVertical = totalVertical + instance.getValue();
                    break;
                case 'D':
                    totalVertical = totalVertical - instance.getValue();
                    break;
                case 'L':
                    totalHorizontal = totalHorizontal + instance.getValue();
                    break;
                case 'R':
                    totalHorizontal = totalHorizontal - instance.getValue();
                    break;
                default:
                    return false;
            }
        }

        return totalHorizontal == 0 && totalVertical == 0;
    }
}
