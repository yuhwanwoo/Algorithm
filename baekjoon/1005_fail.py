from collections import deque
import sys

input=sys.stdin.readline

t = int(input())


while t:
    n, k = map(int, input().split())
    xvalue = [0] * (n+2)
    indegree = [0] * (n+1)

    build_time = [0] + list(map(int, input().split()))
    graph = [[] for _ in range(n+1)]

    for i in range(k):
        s, e = map(int, input().split())
        graph[s].append(e)
        indegree[e] += 1
    
    q=deque()

    for i in range(1,n+1):
        if indegree[i] == 0:
            q.append((i,1))
            if xvalue[1] < build_time[i]:
                xvalue[1] = build_time[i]
    
    # print(xvalue)
    target=int(input())
    answer=int(1e9)
    tmp=[]
    while q:
        now, deg = q.popleft()
        if i == target:
            answer=min(answer,sum(xvalue[1:deg]))
        # print(now,deg)
        for i in graph[now]:
            indegree[i] -= 1
            # print(i,xvalue)
            if xvalue[deg+1] < build_time[i]:
                xvalue[deg+1] = build_time[i]
            
            if indegree[i] == 0:
                q.append((i,deg+1))
    # if answer == int(1e9):
    #     answer=xvalue[1]
    # else:
    #     answer+=build_time[target]
    # print(tmp)
    print(xvalue)
    print("ans:",answer+build_time[target])
    t-=1