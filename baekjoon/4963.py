from collections import deque
import sys

sys.setrecursionlimit(10**9)

dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,1,1,1,0,-1,-1,-1]


while True:
    r,c=map(int,input().split())
    if r==0 and c==0:
        break
    arr=[]

    q=deque()

    for i in range(c):
        arr.append(list(map(int,input().split())))
        # for j in range(r):
        #     if arr[i][j]==1:
        #         q.append((i,j))
    
    visited=[[False]*r for _ in range(c)]
    cnt=0

    def dfs(x,y):
        visited[x][y]=True

        for i in range(8):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=c or ny>=r:
                continue
            if arr[nx][ny]==1 and not visited[nx][ny]:
                dfs(nx,ny)

        return

    

    for i in range(c):
        for j in range(r):
            if arr[i][j]==1 and not visited[i][j]:
                dfs(i,j)
                cnt+=1
    
    print(cnt)