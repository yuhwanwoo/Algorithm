# DFS와 BFS
from collections import deque

def dfs(graph,v,visited):
    visited[v]=True
    print(v,end=' ')
    for i in graph[v]:
        if visited[i]==False:
            dfs(graph,i,visited)

def bfs(graph,v,visited):
    q=deque([v])
    visited[v]=True
    while q:
        top=q.popleft()
        visited[top]=True
        print(top,end=' ')
        for i in graph[top]:
            if visited[i]==False:
                q.append(i)
                visited[i]=True

m,n,k=map(int,input().split())

visited=[False]*(m+1)
graph=[[]for _ in range(m+1)]

for i in range(n):
    a,b=map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()


dfs(graph,k,visited)
visited=[False]*(m+1)
print()
bfs(graph,k,visited)


    