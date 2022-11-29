class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= k; i++){
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);

            for(int[] flight : flights){
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if(prices[source] == Integer.MAX_VALUE) continue;

                if(prices[source] + price < temp[destination]){
                    temp[destination] = prices[source] + price;
                }
            }
            prices = temp;
        }
        if(prices[dst] != Integer.MAX_VALUE) return prices[dst];
        return -1;
    }
}
