import sys

input = sys.stdin.readline

r, c = map(int, input().split())

graph = []
aArr = [[0] * c for _ in range(r)]
aSum = [[0] * c for _ in range(r)]
bArr = [[0] * c for _ in range(r)]
bSum = [[0] * c for _ in range(r)]

for i in range(r):
    graph.append(list(map(str, input().split())))

for i in range(1, r):
    for j in range(1, c):
        print(i, j)
        banana = int(graph[i - 1][j][1]) if graph[i - 1][j][0] == 'B' else 0
        bSum[i][j] = bSum[i - 1][j] + banana

for i in range(r - 2, -1, -1):
    for j in range(c - 1, -1, -1):
        apple = int(graph[i + 1][j][1]) if graph[i + 1][j][0] == 'A' else 0
        aSum[i][j] = aSum[i + 1][j] + apple

print(bSum)
print(aSum)
print(graph)