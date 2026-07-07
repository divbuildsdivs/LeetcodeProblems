class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 1;
        
        for(int i = 0; i < piles.length; i++){
            max = Math.max(piles[i], max);
        }
        int k = max;

        while(min <= max){
            int mid = (min + max)/2;
            // System.out.println("min: " + min +": max: "+ max + " mid: " + mid);
            int calcHours = calculateHours(piles,mid);
            // System.out.println("calcHours: " + calcHours);
            if(calcHours <= h && calcHours > 0) {
                k = Math.min(mid, k);
                max = mid - 1;
                // System.out.println("k: " + k);
            }
            else {
                min = mid + 1;
            }

        }
        return k;
    }
    int calculateHours(int[] piles, int num) {
        int h = 0;
        for(int i = 0; i < piles.length; i++) {
            h = h + piles[i]/num;
            if(piles[i]%num != 0){
                h = h + 1;
            }
           // h = h + Math.ceil(piles[i]/num);
        }
        return h;
    }
}