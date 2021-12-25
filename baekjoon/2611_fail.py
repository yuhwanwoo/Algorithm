# https://www.acmicpc.net/source/share/528c4aa3c991463db46d79f859a1dc86

from collections import deque
import sys

input=sys.stdin.readline

n=int(input())
m=int(input())

indegree=[0]*(n+1)
graph=[[] for _ in range(n+1)]
result=[[0,""] for _ in range(n+1)]
visited=[False]*(n+1)
q=deque()

for i in range(m):
    s,e,d=map(int,input().split())
    graph[s].append((e,d))
    indegree[e]+=1

result[1][1]="1"
q.append(1)

def ind():
    while q:
        now=q.popleft()
        visited[now]=False
        for loc in graph[now]:
            i,cost=loc
            indegree[i]-=1
            if result[i][0]<=result[now][0]+cost:
                result[i][0]=result[now][0]+cost
                result[i][1]=result[now][1]
                result[i][1]+=str(i)
                if not visited[i] and i!=1:
                    q.append(i)

ind()
# print(result)
print(result[1][0])
print(*list(result[1][1]))