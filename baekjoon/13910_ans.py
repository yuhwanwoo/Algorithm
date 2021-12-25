n, m = map(int, input().split())
li = list(map(int, input().split()))

visited = [False] * (20002)

maximum = int(1e9)
dp = [0] + [maximum] * (n+1)

visited[0] = True

for i in range(m):
    visited[li[i]] = True
    for j in range(i+1, m):
        visited[li[i] + li[j]] = True

for i in range(1, n+1):
    if not visited[i]:
        continue
    for j in range(i, n+1):
        dp[j] = min(dp[j], dp[j - i] + 1)

if dp[n] == maximum :
    print(-1)
else:
    print(dp[n])