from collections import deque

n,m,k,x=map(int,input().split())

data=[[] for _ in range(n+1)]

for i in range(m):
    a,b=map(int,input().split())
    data[a].append(b)

distance=[-1]*(n+1)

distance[x]=0

q=deque([x])
while q:
    top=q.popleft()

    for i in data[top]:
        if distance[i]==-1:
            distance[i]=distance[top]+1
            q.append(i)

print(distance)