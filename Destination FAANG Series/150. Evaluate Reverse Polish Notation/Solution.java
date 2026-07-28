class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> nums = new Stack<>();
        for(int i =0; i<tokens.length; i++){
            if(tokens[i].equals("+") ||tokens[i].equals("-") ||tokens[i].equals("*") ||tokens[i].equals("/")) {
                nums.push(calculate(nums, tokens[i]));
            }
            else {
                nums.push(tokens[i]);
            }
        }
        return Integer.parseInt(nums.pop());
    }
    String calculate(Stack<String>nums, String token) {
        int num2 = Integer.parseInt(nums.pop());
        int num1 = Integer.parseInt(nums.pop());
        int result = 0;
        if(token.equals("+")) {
            result = num1 + num2;
        } 
        else if(token.equals("-")) {
           result = num1 - num2;
        }
        else if(token.equals("*")) {
            result = num1 * num2;
        }
        else {
            result = num1 / num2;
        }
        // System.out.println(num1 + " "+token + "  "+num2 + " = "+ result );
        return ""+result;
    }
}