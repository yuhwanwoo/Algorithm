n=int(input())

dummy=[[0]*(n+1) for _ in range(n+1)]

k=int(input())
for _ in range(k):
    a,b=map(int,input().split())
    dummy[a][b]=1

time=0

dx=[1,0,-1,0]
dy=[0,-1,0,1]

def rot_direction(direction,c):

    return 0

time=0
index=0
x,y=1,1
direction=0
q=[(x,y)]
while True:

    nx=x+dx[direction]
    ny=y+dy[direction]
    
    if nx>=1 and nx<=n and ny>=1 and ny<=n and dummy[nx][ny]!=2:
        if dummy[nx][ny]==0:

    else:
        time+=1
        break
