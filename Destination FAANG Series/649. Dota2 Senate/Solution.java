class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rad = new ArrayDeque<> ();
        Queue<Integer> dir = new ArrayDeque<> ();
        for(int i =0; i<n ;i++){
            if(senate.charAt(i) == 'R')
                rad.offer(i);
            else
                dir.offer(i);
        }

        while(!rad.isEmpty() && !dir.isEmpty()){
            int rval = rad.poll();
            int dval = dir.poll();
            if(rval < dval) {
                rad.offer( rval + n);
            }
            else {
                dir.offer(dval + n);
            }
        }
        return (!rad.isEmpty()) ? "Radiant" : "Dire";
    }
}