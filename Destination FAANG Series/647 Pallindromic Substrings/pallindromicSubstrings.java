class Solution {
    public int countSubstrings(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++){
            total = total + checkPallindrome(s, i, i);
            total = total + checkPallindrome(s, i, i+1);
        }
        return total;
    }
    int checkPallindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right <= s.length() - 1 ) {
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            count++;
            left--;
            right++;
        }
        return count;
    }
}
 