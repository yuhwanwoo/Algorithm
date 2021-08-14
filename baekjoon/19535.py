n = int(input())

graph = [[] for _ in range(n + 1)]

for i in range(n-1):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

print(graph)