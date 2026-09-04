class ShortestRoute {
	public static int minPath(int r, int c, int grid[][]) {
		if (r <= 0 && c <= 0) {
			return 0;
		}
		int costGrid[][] = new int[r][c];
		costGrid[0][0] = grid[0][0];
		for(int i = 1; i < r; i++) {
			costGrid[i][0] = costGrid[i - 1][0] + grid[i][0];
		}
		for(int j = 1; j < c; j++) {
			costGrid[0][j] = costGrid[0][j - 1] + grid[0][j];
		}
		for(int i = 1; i < r; i++) {
			for(int j = 1; j < c; j++) {
				costGrid[i][j] = grid[i][j] + Math.min(costGrid[i][j - 1], costGrid[i - 1][j]);
			}
		}
		return costGrid[r - 1][c - 1];
	}
	public static void main(String[] args) {
        int r = 3;
        int c = 3;
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
		System.out.println(minPath(r, c, grid));
	}
}
