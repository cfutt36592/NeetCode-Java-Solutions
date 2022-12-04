class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = 0;
        int cSum = 0;
        for(int g : gas) gSum += g;
        for(int c : cost) cSum += c;
        if(gSum < cSum) return -1;
        
        int res = 0;
        int total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            if(total < 0){
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
