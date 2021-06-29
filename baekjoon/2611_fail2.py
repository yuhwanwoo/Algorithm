from collections import deque
import copy
import sys

input=sys.stdin.readline

n=int(input())
m=int(input())

indegree=[0]*(n+1)
graph=[[] for _ in range(n+1)]
result=[[0,[]] for _ in range(n+1)]

q=deque()

for i in range(m):
    s,e,d=map(int,input().split())
    graph[s].append((e,d))
    indegree[e]+=1

result[1][1].append(1)
q.append(1)

while q:
    now=q.popleft()

    for loc in graph[now]:
        i,cost=loc
        indegree[i]-=1
        if result[i][0]<result[now][0]+cost:
            result[i][0]=result[now][0]+cost
            result[i][1]=copy.deepcopy(result[now][1])
            result[i][1].append(i)
        if indegree[i]==0:
            if indegree[1]==0:
                break
            q.append(i)

print(result[1][0])
print(result[1][1])