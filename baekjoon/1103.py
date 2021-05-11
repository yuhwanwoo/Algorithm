from collections import deque
import sys

sys.setrecursionlimit(10**9)

n,m=map(int,input().split())

arr=[]
answer=0

for i in range(n):
    # arr.append(list(map(str,input())))
    arr.append(list(map(lambda x:0 if x=='H' else int(x),map(str,input()))))

visited=[[False]*m for _ in range(n)]
cnt_arr=[[0]*m for _ in range(n)]
flag=False
dx=[1,0,-1,0]
dy=[0,-1,0,1]

def dfs(x,y,cnt):
    global answer,flag
    if cnt>answer:
        answer=cnt
    
    cnt_arr[x][y]=cnt

    for i in range(4):
        nx=x+(dx[i]*arr[x][y])
        ny=y+(dy[i]*arr[x][y])
        if nx<0 or ny<0 or nx>=n or ny>=m or arr[nx][ny]==0:
            continue
        if visited[nx][ny]:
            flag=True
            return
        if cnt_arr[nx][ny] > cnt:
            continue
        visited[nx][ny]=True
        dfs(nx,ny,cnt+1)
        visited[nx][ny]=False

visited[0][0]=True
dfs(0,0,1)

if flag:
    print(-1)
else:
    print(answer)