from collections import deque

n,m=map(int,input().split())

indegree = [0]*(n+1)
graph = [[] for _ in range(n+1)]
dic = dict()
for i in range(m):
    arr=list(map(int,input().split()))
    des=arr[-1]
    num=arr[0]
    for i in range(1,num+1):
        graph[arr[i]].append(des)
        indegree[des]+=1

l=int(input())
q=deque()
_list = list(map(int,input().split()))
for i in _list:
    q.append(i)

print(graph)
while q:
    now=q.popleft()
    for i in graph[now]:
        indegree[i]-=1
        if indegree[i]==0:
            q.append(i)
            _list.append(i)

_list=set(_list)
_list=sorted(_list)

print(*_list)