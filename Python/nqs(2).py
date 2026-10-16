def count_queens(N):
    all_cols = (1 << N) - 1
    def dfs(cols, diag1, diag2):
        if cols == all_cols:
            print(count)
            return 1
        available = all_cols & ~(cols | diag1 | diag2)
        count = 0
        while available:
            bit = available & -available
            available -= bit
            count += dfs(
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >> 1
            )
        return count
    total = 0
    # First queen in the left half.
    half = N // 2
    for col in range(half):
        bit = 1 << col

        total += dfs(
            bit,
            bit << 1,
            bit >> 1
        )
    # Mirror the left-half solutions.
    total *= 2
    # Odd N has a middle column without a mirror pair.
    if N % 2:
        bit = 1 << half

        total += dfs(
            bit,
            bit << 1,
            bit >> 1
        )
    return total
N = int(input())
print(count_queens(N))
