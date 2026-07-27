class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')', '(');
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(']', '[');
        int i = 0;
        Stack<Character> brackets = new Stack<> ();

        while(i<s.length()){
            if(!closeToOpenMap.containsKey(s.charAt(i))) {
                brackets.push(s.charAt(i));
            }
            else {
                if(brackets.size() == 0) {
                    return false;
                }
                else if(brackets.pop() != closeToOpenMap.get(s.charAt(i)) ) {
                    return false;
                }
            }
            i++;
        }

        return brackets.size() == 0;
    }
}