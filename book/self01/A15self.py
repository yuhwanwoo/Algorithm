from collections import deque
import sys
input=sys.stdin.readline

n,m,k,x=map(int,input().split())


graph=[[] for _ in range(n+1)]

for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)

distance=[-1]*(n+1)
distance[x]=0

q=deque([x])
while q:
    top=q.popleft()

    for i in graph[top]:
        if distance[i]==-1:
            distance[i]=distance[top]+1
            q.append(i)

answer=[]
for i,dis in enumerate(distance):
    if dis==k:
        answer.append(i)

if answer:
    answer.sort()
    for i in answer:
        print(i)
else:
    print(-1)
