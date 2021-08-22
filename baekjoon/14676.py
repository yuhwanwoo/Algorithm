import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())

indegree = [0] * (n + 1)
graph = [[] for _ in range(n+1)]


for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)

    indegree[e] += 1

for _ in range(k):
    s, e = map(int, input().split())