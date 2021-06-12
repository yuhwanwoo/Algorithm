from collections import deque

w,h=map(int,input().split())

arr=[]
c=[]
INF=int(1e9)
visited=[[INF]*w for _ in range(h)]
dx=[-1,0,1,0]
dy=[0,1,0,-1]
q=deque()

for i in range(h):
    arr.append(list(input()))
    for j in range(w):
        if arr[i][j]=="C":
            c.append((i,j))

def bfs(x,y):
    q.append((x,y))
    visited[x][y]=0

    while q:
        x,y=q.popleft()
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            while True:
                if nx<0 or ny<0 or nx>=h or ny>=w:
                    break
                if arr[nx][ny]=="*":
                    break
                if visited[nx][ny] < visited[x][y]+1:
                    break
                q.append((nx,ny))
                visited[nx][ny]=visited[x][y]+1
                nx=nx+dx[i]
                ny=ny+dy[i]
    return

cx,cy=c[0]
bfs(cx,cy)
print(visited[c[1][0]][c[1][1]]-1)
