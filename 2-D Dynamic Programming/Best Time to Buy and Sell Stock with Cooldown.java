class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> cache = new HashMap<>();
        return dfs(prices, cache, 0, true);
    }

    public int dfs(int[] prices, Map<String, Integer> cache, int index, boolean buying){
        if(index >= prices.length) return 0;

        String key = index + "-" + buying;
        if(cache.containsKey(key)) return cache.get(key);

        int buyOrSell = Integer.MIN_VALUE;
        int cooldown = dfs(prices, cache, index + 1, buying);

        if(buying)
            buyOrSell = dfs(prices, cache, index + 1, false) - prices[index];
        else
            buyOrSell = dfs(prices, cache, index + 2, true) + prices[index];
        
        cache.put(key, Math.max(buyOrSell, cooldown));
        return cache.get(key);
    }
}
