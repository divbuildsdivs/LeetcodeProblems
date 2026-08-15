class Solution {
    public boolean exist(char[][] board, String word) {
        int wordlen = word.length(); 
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length ; j++) {
                HashSet<String> set = new HashSet<>();
                if(dfs(board, word, set, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, HashSet<String> set, int r, int c, int index) {
        int len = word.length();
        if(len == index)
            return true;

       
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index) || set.contains(r + ", " + c) ) {
            return false;
        }
        set.add(r + ", " + c);
         

        boolean res =  dfs(board, word, set, r, c+1, index + 1) ||  dfs(board, word, set, r, c-1, index + 1) ||  dfs(board, word, set, r+1, c, index + 1) ||  dfs(board, word, set, r-1, c, index + 1);

        set.remove(r + ", " + c);
        return res;

    }
}