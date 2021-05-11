from collections import deque

n,m=map(int,input().split())

arr=[]
answer=0

for i in range(n):
    # arr.append(list(map(str,input())))
    arr.append(list(map(lambda x:0 if x=='H' else int(x),map(str,input()))))

visited=[[False]*m for _ in range(n)]
cnt_arr=[[0]*m for _ in range(n)]
flag=False

def bfs(a,b):
    global flag
    dx=[1,0,-1,0]
    dy=[0,-1,0,1]
    q=deque()
    q.append((a,b))
    visited[a][b]=True

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]*arr[x][y]
            ny=y+dy[i]*arr[x][y]
            if nx<0 or ny<0 or nx>=n or ny>=m:
                continue
            if visited[nx][ny]:
                print(nx,ny)
                cnt_arr[nx][ny]=cnt_arr[x][y]+1
                if arr[nx][ny]+nx<n or arr[nx][ny]+ny<m:
                    flag=True
                break
            if arr[nx][ny]==0:
                visited[nx][ny]=True
                cnt_arr[nx][ny]=cnt_arr[x][y]
                continue

            visited[nx][ny]=True
            if cnt_arr[nx][ny]<=cnt_arr[x][y]:
                cnt_arr[nx][ny]=cnt_arr[x][y]+1
            q.append((nx,ny))
            
bfs(0,0)
for i in range(n):
    for j in range(m):
        answer=max(answer,cnt_arr[i][j])

# print(visited)
if flag:
    print(-1)
else:
    print(answer+1)