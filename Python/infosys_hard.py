def solve(n, arr):
    min_pair = float('inf')
    evens = sorted({i for i in arr if not (i & 1)})
    odds = sorted({i for i in arr if i & 1})
    for grp in (evens, odds):
        for i in range(1, len(grp)):
            min_pair = min(min_pair, abs(grp[i] - grp[i - 1]))
    # for i in range(1, n):
    #     for j in range(i):
    #         if arr[i] == arr[j] or (arr[j] - arr[i]) & 1:
    #             continue
    #         min_pair = min(min_pair, abs(arr[j] - arr[i]))
    return min_pair if min_pair != float('inf') else -1

# --- TEST CASES ---

# Test 1: Sample Case 1
print("Test 1 | Output:", solve(6, [41, 54, 15, 4, 54, 4]), "| Expected: 26")
# Test 2: Sample Case 2
print("Test 2 | Output:", solve(6, [45, 6, 38, 6, 15, 38]), "| Expected: 30")
# Test 3: Sample Case 3
print("Test 3 | Output:", solve(6, [6, 59, 1, 25, 59, 50]), "| Expected: 24")
# Test 4: Impossible parity / duplicate trap (only odd diffs or 0 diffs exist)
print("Test 4 | Output:", solve(4, [2, 2, 5, 5]), "| Expected: -1")
# Test 5: Minimum N = 1 (no pairs possible)
print("Test 5 | Output:", solve(1, [10]), "| Expected: -1")
# Test 6: Equal values forbidden (must skip |10 - 10| = 0)
print("Test 6 | Output:", solve(4, [10, 10, 10, 16]), "| Expected: 6")
# Test 7: Direction check (j < i strictly required)
print("Test 7 | Output:", solve(3, [10, 3, 8]), "| Expected: 2")
# Test 8: Best valid pair at the very end
print("Test 8 | Output:", solve(5, [100, 1, 50, 12, 14]), "| Expected: 2")
