class Solution:
    def stoneGame(self, stones):
        n = len(stones)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = stones[i]
        for s in range(1, n):
            for i in range(n - s):
                j = i + s
                dp[i][j] = max(stones[i] - dp[i + 1][j], stones[j] - dp[i][j - 1])
        return dp[0][n - 1] > 0

# --- TEST EXAMPLES ---
sol = Solution()

# Test Case 1: The exact example we traced together
test_1 = [5, 3, 4, 5]
result_1 = sol.stoneGame(test_1)
print(f"Input: {test_1}")
print(f"Output: {result_1} (Expected: True)\n")

# Test Case 2: A different setup where Alice wins cleanly
test_2 = [3, 7, 2, 3]
result_2 = sol.stoneGame(test_2)
print(f"Input: {test_2}")
print(f"Output: {result_2} (Expected: True)")
