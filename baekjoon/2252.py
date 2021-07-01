from collections import deque
import sys

input=sys.stdin.readline

n,m=map(int,input().split())

graph=[[] for _ in range(n+1)]
indegree=[0]*(n+1)

visited=[0]*(n+1)



for i in range(m):
    st,ed=map(int,input().split())
    graph[st].append(ed)
    indegree[ed]+=1

q=deque()
for i in range(1,n+1):
    if indegree[i]==0:
        q.append(i)

ans=[]
while q:
    now=q.popleft()
    ans.append(now)
    for i in graph[now]:
        indegree[i]-=1
        if indegree[i]==0:
            q.append(i)

print(*ans)