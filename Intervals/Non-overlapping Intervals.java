class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int numRemoved = 0;

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] firstInterval = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(overlap(firstInterval, intervals[i])){
                numRemoved++;

                //interval to compare is whichever overlapping interval ends first
                if(firstInterval[1] > intervals[i][1]){
                    firstInterval = intervals[i];
                }
            }
            else{
                firstInterval = intervals[i];
            }
        }

        return numRemoved;
    }

    public boolean overlap(int[] first, int[] second){
        return first[1] > second[0];
    }
}
