class KthLargest {

    private PriorityQueue<Integer> heap;
    private int size;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        size = k;
        for(int num : nums) add(num);
    }
    
    public int add(int val) {
        if(heap.size() < size) heap.offer(val);
        else if(val > heap.peek()){
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
