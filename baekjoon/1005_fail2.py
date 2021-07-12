from collections import deque

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
    n=int(input())
    answer=int(1e9)
    while q:
        now, deg = q.popleft()
        if now == n:
            answer=min(answer,sum(xvalue[:deg]))
            answer+=build_time[now]
        # print(now,deg)
        for i in graph[now]:
            indegree[i] -= 1
            # print(i,xvalue)
            if xvalue[deg+1] < build_time[i]:
                xvalue[deg+1] = build_time[i]

            if indegree[i] == 0:
                q.append((i,deg+1))
    
    # print(xvalue)
    print("ans",answer)
    t-=1