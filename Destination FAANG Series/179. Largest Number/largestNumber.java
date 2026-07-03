class Solution {
    public String largestNumber(int[] nums) {

        // Convert all integers to strings because we need to concatenate
        // numbers during comparison (e.g., "3" + "30" vs "30" + "3").
        String[] numsStr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = "" + nums[i];
        }

        // Sort using a custom comparator.
        Arrays.sort(numsStr, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {

                // Two possible ways to arrange the numbers.
                String s1 = a + b;
                String s2 = b + a;

                // We want the arrangement that forms the larger number.
                //
                // Example:
                // a = "3", b = "30"
                // s1 = "330"
                // s2 = "303"
                //
                // Since "330" > "303",
                // "3" should come before "30".
                //
                // compareTo() returns:
                // Negative -> s2 < s1
                // Zero     -> equal
                // Positive -> s2 > s1
                //
                // Returning s2.compareTo(s1) sorts in descending order
                // based on the concatenated value.
                return s2.compareTo(s1);
            }
        });

        // Build the final answer by concatenating the sorted strings.
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            res.append(numsStr[i]);
        }

        // Edge case:
        // If the largest element is "0", then every element is "0".
        // Example: [0,0] -> "00"
        // Return only one "0".
        if (res.charAt(0) == '0') {
            return "0";
        }

        return res.toString();
    }
}