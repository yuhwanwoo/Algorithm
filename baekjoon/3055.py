from collections import deque

r,c=map(int,input().split())

arr=[]
dx=[-1,0,1,0]
dy=[0,1,0,-1]

dist1=[[-1]*c for _ in range(r)]
dist2=[[-1]*c for _ in range(r)]

for i in range(r):
    arr.append(list(map(str,input())))

for i in range(r):
    print(arr[i])
    

water=deque()
place=deque()
dis=tuple()

for i in range(r):
    for j in range(c):
        if arr[i][j]=="*":
            water.append((i,j))
            dist1[i][j]=0
        if arr[i][j]=="S":
            place.append((i,j))
            dist2[i][j]=0
        if arr[i][j]=="D":
            dis=(i,j)
            
# 물에 대한 bfs
while water:
    x,y=water.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or ny<0 or nx>=r or ny>=c:
            continue
        if arr[nx][ny]=='X' or arr[nx][ny]=='D' or dist1[nx][ny]>=0:
            continue
        dist1[nx][ny]=dist1[x][y]+1
        water.append((nx,ny))
    

# print(dist1)

while place:
    x,y=place.popleft()
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx<0 or ny<0 or nx>=r or ny>=c:
            continue
        if dist2[nx][ny]>=0 or arr[nx][ny]=='X':
            continue
        if dist1[nx][ny]!=-1 and dist1[nx][ny]<=dist2[x][ny]+1:
            continue
        dist2[nx][ny]=dist2[x][y]+1
        place.append((nx,ny))

# print(dist2)
if dist2[dis[0]][dis[1]]==-1:
    print("KAKTUS")
else:
    print(dist2[dis[0]][dis[1]])