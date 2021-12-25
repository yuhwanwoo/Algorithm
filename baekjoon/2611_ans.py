from collections import deque
import sys

input=sys.stdin.readline

n=int(input())
m=int(input())

indegree=[0]*(n+1)
graph=[[] for _ in range(n+1)]
di=[0]*(n+1)
inq=[False]*(n+1)
pa=[0]*(n+1)

q=deque()

for i in range(m):
    s,e,d=map(int,input().split())
    graph[s].append((e,d))
    indegree[e]+=1

q.append(1)

while q:
    now=q.popleft()
    inq[now]=False
    for loc in graph[now]:
        i,cost=loc
        
        if di[i]<di[now]+cost:
            di[i]=di[now]+cost
            # result[i][1]=result[now][1]
            # result[i][1]+=str(i)
            pa[i]=now
            if not inq[i] and i!=1:
                inq[i]=True
                q.append(i)

v=1
m=0
print(di[1])
while True:
    di[m]=v
    m+=1
    v=pa[v]
    if v==1:
        di[m]=1
        m+=1
        break

for i in range(m-1,-1,-1):
    print(di[i],end=' ')
