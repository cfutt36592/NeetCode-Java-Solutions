class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);   
        }

        int[] ret = new int[k];

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) ->
            a.getValue() - b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int i = k-1;
        while(!pq.isEmpty()){
            ret[i] = pq.poll().getKey();
            i--;
        }
        
        return ret;
    }
}
