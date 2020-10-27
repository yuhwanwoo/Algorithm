n=int(input())

dummy=[[0]*(n+1) for _ in range(n+1)]

k=int(input())
for _ in range(k):
    a,b=map(int,input().split())
    dummy[a][b]=1

time=0

dx=[1,0,-1,0]
dy=[0,-1,0,1]

def rot_direction():
    return 0