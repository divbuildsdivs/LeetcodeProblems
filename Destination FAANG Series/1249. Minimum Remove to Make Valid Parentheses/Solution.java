class Solution {
    public String minRemoveToMakeValid(String s) {
       Stack<Integer> brackets = new Stack<>();
       Set<Integer> indexToRemove = new HashSet<Integer>(); 
       for(int i=0; i<s.length();i++){
        if(s.charAt(i) == '(') {
            brackets.push(i);
        }
        else if(s.charAt(i) == ')' && !brackets.isEmpty()){
            brackets.pop();
        }
        else if(s.charAt(i) == ')' && brackets.isEmpty()){
            indexToRemove.add(i);
        }
       }
       while(!brackets.isEmpty()){
        indexToRemove.add(brackets.pop());
       }
       StringBuilder res = new StringBuilder();
       for(int i=0; i<s.length();i++) {
        if(!indexToRemove.contains(i)){
            res.append(s.charAt(i));
        }
       }
       return res.toString();
    }
}