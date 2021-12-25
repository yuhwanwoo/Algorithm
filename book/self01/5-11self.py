from collections import deque

m,n=map(int,input().split())

graph=[]
for i in range(m):
    graph.append(list(map(int,input())))


dx=[-1,1,0,0]
dy=[0,0,-1,1]


def dfs(x,y):
    q=deque()

    q.append((x,y))

    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or nx>=m or ny<0 or ny>=n:
                continue
            if graph[nx][ny]==0:
                continue
            if graph[nx][ny]==1:
                graph[nx][ny]=graph[x][y]+1
                q.append((nx,ny))
    return graph[m-1][n-1]

print(dfs(0,0))