class TrieNode {
    public HashMap<Character, TrieNode> children;
    private boolean isEnd;
    public TrieNode(){
        children = new HashMap<>();;
        isEnd = false;
    }
    public void setEnd() {
        this.isEnd = true;
    }
    public boolean isEnd() {
        return this.isEnd;
    }
    public void addWord(String word) {
        TrieNode root = this;
        for(int i =0 ; i< word.length(); i++){
            if(!root.children.containsKey(word.charAt(i))) {
                root.children.put(word.charAt(i),new TrieNode());
            }
            root = root.children.get(word.charAt(i));
        }
        root.setEnd();
    }
}
class Solution {
    char[][] fullboard;
    Set<String> res = new HashSet<>();
    int totalRows;
    int totalColumns;

    public List<String> findWords(char[][] board, String[] words) {
        this.fullboard = board;
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            root.addWord(words[i]);
        }
        totalRows = board.length;
        totalColumns = board[0].length;
        for(int r = 0; r < totalRows; r++) {
            for(int c =0; c < totalColumns; c++ ) {
                dfs(r, c, "", root);
            }
        }
        List<String> reslist = List.copyOf(res);
        return reslist;

    }

    public void dfs(int r, int c, String wordFormed, TrieNode parent) {
        if(r < 0 || r >= totalRows || c < 0 || c >= totalColumns || fullboard[r][c] == '#'||!parent.children.containsKey(fullboard[r][c])) {
            return;
        }
        char letter = fullboard[r][c];
        fullboard[r][c] = '#';
         String newWord = wordFormed + letter;
        TrieNode current = parent.children.get(letter);
        // Found a complete word
        if (current.isEnd()) {
            res.add(newWord);
        }
        
        // Explore neighbours
        dfs(r + 1, c, newWord, current);
        dfs(r - 1, c, newWord, current);
        dfs(r, c + 1, newWord, current);
        dfs(r, c - 1, newWord, current);
        
        fullboard[r][c] = letter;
    }
}