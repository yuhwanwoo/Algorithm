from collections import deque

r,c=map(int,input().split())

arr=[]

visited=[[False]*c for _ in range(r)]

sheep=[]
wolf=[]

dx=[1,0,-1,0]
dy=[0,-1,0,1]

for i in range(r):
    arr.append(list(input()))
    for j in range(c):
        if arr[i][j]=='k':
            sheep.append((i,j))
        if arr[i][j]=='v':
            wolf.append((i,j))

def bfs(x,y,ns,nw):
    if visited[x][y]==True:
        return [0,0]
    
    visited[x][y]=True
    q=deque()
    q.append((x,y))


    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx<0 or ny<0 or nx>=r or ny>=c:
                continue
            if arr[nx][ny]=='#' or visited[nx][ny]==True:
                continue
            visited[nx][ny]=True
            if arr[nx][ny]=='v':
                nw+=1
            if arr[nx][ny]=='k':
                ns+=1
            q.append((nx,ny))
    
    return [ns,nw]

ts=0
tw=0

for i in range(len(sheep)):
    x,y=sheep[i]
    temp=bfs(x,y,1,0)
    if temp[0]>temp[1]:
        ts+=temp[0]
    else:
        tw+=temp[1]

for i in range(len(wolf)):
    x,y=wolf[i]
    temp=bfs(x,y,0,1)
    if temp[0]>temp[1]:
        ts+=temp[0]
    else:
        tw+=temp[1]

print(ts,tw)