class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for(int i =0; i< position.length; i++) {
            cars[i][0] =position[i];
            cars[i][1] =(double) (target - position[i])/speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));
        double currentFleet = 0;
        int fleetCount = 0;
        for(int i =0; i< position.length; i++){
           // System.out.println("car["+i+"] position: "+ cars[i][0] +  " time: "+ cars[i][1]  );
            if(cars[i][1] > currentFleet) {
                currentFleet = cars[i][1];
                fleetCount++;
            }
           // System.out.println("currentFleet: "+ currentFleet);
        }
        return fleetCount;
    }
}