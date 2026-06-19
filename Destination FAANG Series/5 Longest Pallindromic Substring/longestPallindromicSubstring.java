class Solution {
    public String longestPalindrome(String s) {
        String longestSubstring = "";
        int maxLength = 0;
        int center = 0;
        int start = 0;
        int end = 0;
        for(int i =0; i<s.length(); i++) {
            int pal1 = checkPallindrome(s, i, i);
            int pal2 = checkPallindrome(s, i, i+1);
           if((pal1 > pal2 ? pal1 : pal2) > maxLength) {
            maxLength = pal1 > pal2 ? pal1 : pal2;
            center = i;
           }
        }
        start = center - ((maxLength-1)/2);
        end = center + (maxLength/2) +1;
        longestSubstring = s.substring(start, end);
        return longestSubstring;
        
    }
    int checkPallindrome(String s, int left, int right) {
        int length = 0;
        while(left >=0 && right <= s.length()-1){
            if(s.charAt(left) != s.charAt(right)){
                break;
            }
            length = right - left + 1;
            left --;
            right++;
        }
        return length;
    }
}