# 사이클 판별할 때 쓴 알고리즘
# https://hongl.tistory.com/60?category=922907

from collections import deque

n,m=map(int,input().split())

graph=[[] for _ in range(n+1)]
indegree=[0]*(n+1)

visited=[0]*(n+1)

def dfs(here):
    if visited[here]:
        if visited[here] ==-1:
            return True
        return False
    
    visited[here] = -1
    for node in graph[here]:
        if dfs(node):
            return True
    visited[here]=1
    return False

for i in range(m):
    arr=list(map(int,input().split()))
    for j in range(2,len(arr)):
        graph[arr[j-1]].append((arr[j]))
        indegree[arr[j]]+=1

q=deque()
for i in range(1,n+1):
    if indegree[i]==0:
        q.append(i)
flag=True
for i in range(1,n+1):
    if dfs(i):
        print(0)
        flag=False
        break
if flag:
    while q:
        now=q.popleft()
        print(now)
        for i in graph[now]:
            indegree[i]-=1
            if indegree[i]==0:
                q.append(i)