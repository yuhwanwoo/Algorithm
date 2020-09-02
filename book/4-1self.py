n=int(input())
plan=input().split()
x,y=0,0

dx=[0,0,-1,1]
dy=[-1,1,0,0]
rot=['L','R','U','D']

for i in plan:
    for j in range(len(rot)):
        if rot[j]==i:
            nx=x+dx[j]
            ny=y+dy[j]
    if(nx<0 or ny<0 or nx>=n or ny>=n):
        continue
    x,y=nx,ny
print(x+1,y+1)