# 가장 먼 노드
from collections import deque

def solution(n, edge):
    answer = 0

    node=dict()

    for i in range(len(edge)):
        node[edge[i][0]]=node.get(edge[i][0],[])+[edge[i][1]]

    for i in node.keys():
        node[i].sort()
    q=deque()
    visited=[False]*n
    cnt=0
    for i in node[1]:
        q.append(i)
        cnt+=1
        visited[i]=True
        
        while q:
            top=q.popleft()


    return answer

n=6
edge=[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
solution(n,edge)