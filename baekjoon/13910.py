n, m = map(int, input().split())
li = list(map(int, input().split()))

st = set(li)
for i in range(m):
    for j in range(i + 1, m):
        st.add(li[i] + li[j])

maximum = 10001
dp = [maximum] * (n+1)

dp[0] = 0

for value in st:
    for i in range(len(dp)):
        if dp[i] != maximum and i + value <= n:
            dp[i + value] = min(dp[i] + 1, dp[i + value])

if dp[-1] == maximum:
    print(-1)
else:
    print(dp[-1])