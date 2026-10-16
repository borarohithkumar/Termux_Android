from functools import cache
class Solution:
    def stoneGame(self, stones):
        n = len(stones)
        @cache
        def play(i, j):
            if i == j:
                return stones[i]
            playLeft = stones[i] - play(i + 1, j)
            playRight = stones[j] - play(i, j - 1)
            return max(playLeft, playRight)
        return play(0, n - 1) > 0
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
