package hashTable;

import java.util.*;

public class SubdomainVisitCount {

    public static void main(String[] args) {
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();

//        System.out.println(subdomainVisitCount.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));

        System.out.println(subdomainVisitCount.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public List<String> subdomainVisits(String[] cpdomains) {

        System.out.println(Arrays.toString(cpdomains));
        List<String> result = new ArrayList<>();

        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String i : cpdomains) {
            String[] k = i.split(" ");
            hashMap.put(k[1], Integer.valueOf(k[0]));
            stack.add(k[1]);
        }


        while (!stack.isEmpty()) {
            String s = stack.pop();
            Integer currentValue = hashMap.get(s);

            if (currentValue == null) {
                currentValue = 1;
            }

            String[] dots = s.split("[.]");

            String currrentString = null;
            for (int i = dots.length - 1; i >= 1; i--) {
                if (currrentString == null) {
                    currrentString = dots[i];
                } else {
                    currrentString = dots[i] + "." + currrentString;
                }

                Integer v = hashMap.get(currrentString);
                if (v == null) {
                    hashMap.put(currrentString, currentValue);
                } else {
                    hashMap.put(currrentString, currentValue + v);
                }

            }
        }

        hashMap.forEach((key, value) -> result.add(value + " " + key));

        return result;
    }
}
