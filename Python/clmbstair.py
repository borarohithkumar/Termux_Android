class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n
        # dp = [0] * (n + 1)
        # dp[1] = 1
        # dp[2] = 2
        # for i in range(3, n + 1):
        #     dp[i] = dp[i - 1] + dp[i - 2]
        # return dp[i]

        f = 1
        s = 2
        for _ in range(n - 2):
            temp = f
            f = s
            s = temp + s
        return s
def main():
        sol = Solution()
        n = int(input())
        print(sol.climbStairs(n))
if __name__ == '__main__':
    main()
