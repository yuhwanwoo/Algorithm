n = int(input())

dp = [0]*5001

dp[3] = 1
dp[4] = -1
dp[5] = 1
dp[6] = 2
dp[7] = -1
dp[8] = 2
dp[9] = 3
dp[10] = 2
dp[11] = 3
dp[12] = 4

for i in range(13,5001):
    dp[i] = min(dp[i - 3] + 1, dp[i - 5] + 1)

print(dp[n])