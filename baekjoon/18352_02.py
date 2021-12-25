from collections import deque

n,m,k,x=map(int,input().split())
distance=[-1]*(n+1)

graph=[[] for _ in range(n+1)]

for i in range(m):
    start,end=map(int,input().split())
    graph[start].append(end)

distance[x]=0

answer=[]

q=deque([x])
while q:
    now=q.popleft()
    for node in graph[now]:
        if distance[node]==-1:
            distance[node]=distance[now]+1
            q.append(node)

for i in range(len(distance)):
    if distance[i]==k:
        answer.append(i)

if answer:
    for i in answer:
        print(i)
else:
    print(-1)