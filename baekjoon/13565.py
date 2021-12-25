from collections import deque

m,n=map(int,input().split())

dx=[0,1,0,-1]
dy=[1,0,-1,0]

arr=[]
visited=[[False]*n for _ in range(m)]
q=deque()

for i in range(m):
    arr.append(list(map(int,input())))
    # 맨 윗줄이 0인 부분만 q에 저장
    for j in range(n):
        if i==0 and arr[i][j]==0:
            arr[i][j]=2
            q.append((i,j))

flag=False

while q:
    cx,cy=q.popleft()
    if cx==m-1:
        flag=True
        break

    for i in range(4):
        nx=cx+dx[i]
        ny=cy+dy[i]
        if nx<0 or ny<0 or nx>=m or ny>=n:
            continue
        if arr[nx][ny]==0:
            if nx==m-1:
                flag=True
                break
            arr[nx][ny]=2
            q.append((nx,ny))
    if flag:
        break

if flag:
    print("YES")
else:
    print("NO")