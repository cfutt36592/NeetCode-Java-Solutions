class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int stone : stones) maxHeap.add(stone * -1);

        while(maxHeap.size() > 1){
            int big = maxHeap.poll();
            int small = maxHeap.poll();
            if(big != small) maxHeap.add(big - small);
        }

        if(maxHeap.size() > 0) return maxHeap.peek() * -1;
        else return 0; 
    }
}
