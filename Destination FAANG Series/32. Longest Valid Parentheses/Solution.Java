class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> openingBrackets = new Stack<>();
       Set<Integer> indexToRemove = new TreeSet<>();
       for(int i=0; i<s.length(); i++) {
        if(s.charAt(i) == ')' && openingBrackets.isEmpty()){
            indexToRemove.add(i);
        }
        else if(s.charAt(i) == ')' && !openingBrackets.isEmpty()) {
            indexToRemove.remove(openingBrackets.pop());
        }
        else {
            openingBrackets.push(i);
            indexToRemove.add(i);
        }
       }
       Iterator<Integer> iterator = indexToRemove.iterator();
       int lastIndex = -1;
       int maxLength = 0;

       while(iterator.hasNext()){
        int currIndex = iterator.next();
        System.out.println(currIndex);
        maxLength = Math.max(maxLength, (currIndex - lastIndex - 1));
        lastIndex = currIndex;
       }
        maxLength = Math.max(maxLength, (s.length() - lastIndex - 1));

       return maxLength;
    }
}