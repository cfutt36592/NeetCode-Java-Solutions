class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int i = 0; i < cols; i++){
            dfs(heights, 0, i, -1, pac);
            dfs(heights, rows - 1, i, -1, atl);
        }

        for(int i = 0; i < rows; i++){
            dfs(heights, i, 0, -1, pac);
            dfs(heights, i, cols - 1, -1, atl);
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        
        return res;
    }

    public void dfs(int[][] heights, int r, int c, int prev, boolean[][] ocean){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) return;
        if(heights[r][c] < prev || ocean[r][c]) return;

        ocean[r][c] = true;

        dfs(heights, r + 1, c, heights[r][c], ocean);
        dfs(heights, r - 1, c, heights[r][c], ocean);
        dfs(heights, r, c + 1, heights[r][c], ocean);
        dfs(heights, r, c - 1, heights[r][c], ocean);
    }
}
