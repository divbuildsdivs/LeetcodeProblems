class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        int resultLength = s.length() + 1;
        int resultStart = 0;
        int resultEnd = 0;
        int right = 0, left = 0;
        StringBuilder distinctString = new StringBuilder();
        if (t.length() > s.length()) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            if (tmap.containsKey(t.charAt(i))) {
                tmap.replace(t.charAt(i), tmap.get(t.charAt(i)) + 1);
            } else {
                tmap.put(t.charAt(i), 1);
                distinctString = distinctString.append(t.charAt(i));
            }
        }
        while (right < s.length()) {
            System.out.println("right: " + right + " left: " + left);
            if (left < resultEnd) {
                if (smap.get(s.charAt(left)) == 1) {
                    smap.remove(s.charAt(left));
                } else {
                    smap.replace(s.charAt(left), (smap.get(s.charAt(left)) - 1));
                }
                smap.forEach((key, value) -> System.out.println("key: " + key + " value: " + value));
                left++;
            } else {
                if (smap.containsKey(s.charAt(right))) {
                    smap.replace(s.charAt(right), smap.get(s.charAt(right)) + 1);
                } else {
                    smap.put(s.charAt(right), 1);
                }
            }
            int matches = 0;
            while (matches < distinctString.length()
                && smap.get(distinctString.charAt(matches)) != null
                && (smap.get(distinctString.charAt(matches)) >= tmap.get(distinctString.charAt(matches)))) {
                System.out.println("distinctString.charAt(matches): " + distinctString.charAt(matches));
                System.out.println("smap.get(distinctString.charAt(matches): " + smap.get(distinctString.charAt(matches)));
                System.out.println("tmap.get(distinctString.charAt(matches): " + tmap.get(distinctString.charAt(matches)));
                matches++;
            }
            if (matches == distinctString.length()) {
                System.out.println("right- left + 1" + (right - left + 1) + " resultLength: " + resultLength);
                if ((right - left) < resultLength) {
                    resultLength = right - left + 1;
                    resultStart = left;
                    resultEnd = right;
                }
            }
            if (left == resultEnd) {
                right++;
            }
        }
        if (resultLength == s.length() + 1) {
            return "";
        } else {
            return s.substring(resultStart, resultEnd + 1);
        }
    }

}