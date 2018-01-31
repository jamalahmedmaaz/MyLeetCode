package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamal on 29/1/18.
 */
public class BuyingTickets {
    public static void main(String[] args) {
        System.out.println(new BuyingTickets().buyTickets(new int[]{1, 7, 8, 9, 29, 30}));
    }

    private int buyTickets(int[] calendarDays) {
        if (calendarDays.length > 26) {
            return 30;
        }

        int[] monthdays = new int[32];

        //Array with 1 as start index.
        for (int i = 0; i < calendarDays.length; i++) {
            monthdays[calendarDays[i]] = 1;
        }

        return 30;
    }
}
