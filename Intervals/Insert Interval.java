class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int[] currInterval : intervals){
            if(newInterval == null || currInterval[1] < newInterval[0]){
                res.add(currInterval);
            }
            else if(currInterval[0] > newInterval[1]){
                res.add(newInterval);
                res.add(currInterval);
                newInterval = null;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], currInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currInterval[1]);
            }
        }
        if(newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
