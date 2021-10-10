# https://bubble-dev.tistory.com/entry/%EC%82%AC%EA%B3%BC%EC%99%80-%EB%B0%94%EB%82%98%EB%82%98-boj-3114

import sys

input = sys.stdin.readline

r, c = map(int, input().split())

graph = [["0"] * (c + 1)]

aSum = [[0] * (c + 1) for _ in range(r + 1)]
bSum = [[0] * (c + 1) for _ in range(r + 1)]
tSum = [[0] * (c + 1) for _ in range(r + 1)]
dp = [[0] * (c + 1) for _ in range(r + 1)]

for i in range(r):
    graph.append(["0"] + list(map(str, input().split())))

# for i in range(1, r + 1):
#     for j in range(2, c + 1):
#         print(i, j)
#         banana = int(graph[i - 1][j - 1][1]) if graph[i - 1][j - 1][0] == 'B' else 0
#         bSum[i][j] = bSum[i - 1][j] + banana

for i in range(2, c + 1):
    for j in range(1, r + 1):
        banana = int(graph[j - 1][i][1]) if graph[j - 1][i][0] == 'B' else 0
        bSum[j][i] = bSum[j - 1][i] + banana

for i in range(r - 1, 0, -1):
    for j in range(c, 0, -1):
        apple = int(graph[i + 1][j][1]) if graph[i + 1][j][0] == 'A' else 0
        aSum[i][j] = aSum[i + 1][j] + apple

for i in range(1, r + 1):
    for j in range(1, c + 1):
        tSum[i][j] = bSum[i][j] + aSum[i][j]

for i in range(1, r + 1):
    dp[i][1] = tSum[i][1]

for i in range(2, c + 1):
    for j in range(1, r + 1):
        apple = int(graph[j][i][1]) if graph[j][i][0] == 'A' else 0
        print(apple)
        dp[j][i] = max(dp[j - 1][i - 1], dp[j][i - 1] + tSum[j][i], dp[j - 1][i] - apple)
print(tSum)
print(dp)
print(dp[r][c])