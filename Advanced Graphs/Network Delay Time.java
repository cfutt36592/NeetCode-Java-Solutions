class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[k - 1] = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < times.length; j++){
                int source = times[j][0];
                int target = times[j][1];
                int time = times[j][2];
                if(
                    paths[source - 1] != Integer.MAX_VALUE && 
                    paths[source - 1] + time < paths[target - 1]
                ){
                    paths[target - 1] = paths[source - 1] + time;
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(paths[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, paths[i]);
        }

        return result;
    }
}
