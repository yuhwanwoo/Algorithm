from collections import deque

n,m,k,x=map(int,input().split())

graph=[[] for _ in range(m+1)]

for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)

distance=[-1]*(m+1)

distance[x]=0

q=deque([x])
while q:
    top=q.popleft()

    for i in graph[top]:
        if distance[i]==-1:
            distance[i]=distance[top]+1
            q.append(i)

