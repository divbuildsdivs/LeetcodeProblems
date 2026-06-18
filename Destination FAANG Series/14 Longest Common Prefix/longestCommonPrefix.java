class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int stringNum = 1;
        while(stringNum < strs.length){
            while(!strs[stringNum].startsWith(res) && res.length() > 0){
                res = res.substring(0, res.length() - 1);
            }
            stringNum++;
        }
        return res;
    }
}