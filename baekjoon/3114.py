import sys

input = sys.stdin.readline

r, c = map(int, input().split())

graph = []
Aarr = [[0] * c for _ in range(r)]
Barr = [[0] * c for _ in range(r)]

for i in range(r):
    graph.append(list(map(str, input().split())))
    for j in range(c):
        element = graph[i][j]
        


print(graph)