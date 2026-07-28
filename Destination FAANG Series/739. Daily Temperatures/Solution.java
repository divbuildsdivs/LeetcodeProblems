class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> indexes = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!indexes.isEmpty() && temperatures[i] > temperatures[indexes.peek()]) {
                int index = indexes.pop();
                res[index] = i - index;
            }
            indexes.push(i);
        }
        return res;
    }
}