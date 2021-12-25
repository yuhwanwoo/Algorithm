import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**9)

m, n = map(int, input().split())

visited = [[-1] * n for _ in range(m)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
arr = []

for i in range(m):
    arr.append(list(map(int, input().split())))

def dfs(x, y):
    if x == m - 1 and y == n - 1:
        return 1
    if visited[x][y] != -1:
        return visited[x][y]
    visited[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < m and ny >= 0 and ny < n:
            if arr[nx][ny] < arr[x][y]:
                visited[x][y] += dfs(nx, ny)

    return visited[x][y]


print(dfs(0, 0))