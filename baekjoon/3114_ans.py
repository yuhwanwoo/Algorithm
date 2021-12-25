r, c = map(int, input().split())

arr = [["0"] * (c + 1)]
a = [[0] * (c + 1) for _ in range(r + 1)]
b = [[0] * (c + 1) for _ in range(r + 1)]
t = [[0] * (c + 1) for _ in range(r + 1)]
dp = [[0] * (c + 1) for _ in range(r + 1)]

for i in range(r):
    arr.append(["0"] + list(input().split()))

for i in range(2, c + 1):
    for j in range(1, r + 1):
        now = 0
        if arr[j - 1][i][0] == 'B':
            now = int(arr[j - 1][i][1])
        b[j][i] = b[j - 1][i] + now

for i in range(r - 1, 0, -1):
    for j in range(c, 0, -1):
        now = 0
        if arr[i + 1][j][0] == 'A':
            now = int(arr[i + 1][j][1])
        a[i][j] = a[i + 1][j] + now

for i in range(1, r + 1):
    for j in range(1, c + 1):
        t[i][j] = a[i][j] + b[i][j]

for i in range(1, r + 1):
    dp[i][1] = t[i][1]

for i in range(2, c + 1):
    for j in range(1, r + 1):
        now = 0
        if arr[j][i][0] == 'A':
            now = int(arr[j][i][1])
        dp[j][i] = max(dp[j - 1][i - 1] + t[j][i], dp[j][i - 1] + t[j][i], dp[j - 1][i] - now)

print(dp[r][c])