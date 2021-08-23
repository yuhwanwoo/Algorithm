import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())

indegree = [0] * (n + 1)
graph = [[] for _ in range(n+1)]

visited = [0] * (n + 1)

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)

    indegree[e] += 1

flag = False

for _ in range(k):
    mode, ob = map(int, input().split())

    if mode == 1:
        if indegree[ob] != 0:
            flag = True
            break
        
        visited[ob] += 1
        if visited[ob] == 1:
            for e in graph[ob]:
                indegree[e] -= 1    
    else:
        if visited[ob] <= 0:
            flag = True
            break
        
        visited[ob] -= 1
        if visited[ob] == 0:
            for e in graph[ob]:
                indegree[e] += 1

if flag:
    print("Lier!")
else:
    print("King-God-Emperor")

