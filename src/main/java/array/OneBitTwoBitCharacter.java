package array;

/**
 * Created by jamal on 8/4/18.
 */
public class OneBitTwoBitCharacter {

    public static void main(String[] args) {
        OneBitTwoBitCharacter oneBitTwoBitCharacter = new OneBitTwoBitCharacter();


        System.out.println(oneBitTwoBitCharacter.isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(oneBitTwoBitCharacter.isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(oneBitTwoBitCharacter.isOneBitCharacter(new int[]{0, 0, 0, 0}));
    }

    public boolean isOneBitCharacter_mybadsolution(int[] bits) {
        if (bits.length % 2 != 0) {
            for (int i = 0; i < bits.length - 2; i++) {
                if (bits[i] == 1 && (bits[i + 1] == 1 || bits[i + 1] == 0)) {
                    return true;
                }
            }
        } else {
            int i = 0;

            while (i < bits.length - 2) {
                switch (bits[i]) {
                    case 0:
                        i++;
                    case 1:
                        if (bits[i + 1] == 0 || bits[i + 1] == 1) {
                            i = i + 2;
                        }
                }
            }


        }

        return false;
    }


    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length - 1; ) {
            if (bits[i] == 0) {
                i = i + 1;
            } else {
                i = i + 2;
            }
        }
        return i == (bits.length - 1);
    }
}
