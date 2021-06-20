n,m,a,b,c=map(int,input().split())

graph=[[] for _ in range(n)]
visited=[False]*n

ans=0

for i in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dfs(st):
    visited[st]=True

    for i in graph[st]:
        ed,dis=i


dfs(a)