from collections import deque

n,m=map(int,input().split())

arr=[]
rx,ry=0,0
bx,by=0,0
q=deque()
dx=[0,-1,0,1]
dy=[-1,0,1,0]



for i in range(n):
    arr.append(list(input()))
    for j in range(m):
        if arr[i][j]=="B":
            bx,by=i,j
        if arr[i][j]=="R":
            rx,ry=i,j



def dfs(rx,ry,bx,by,cnt):

    q.append((rx,ry,bx,by))
    while q:
        rx,ry,bx,by=q.popleft()

        for i in range(4):
            nrx=rx+dx[i]
            nry=ry+dy[i]
            nbx=bx+dx[i]
            nby=by+dy[i]
            if i==0:
                while True:
                    if ry<=by:
                        if oversize(nrx,nry):
                            if arr[nrx][nry]=="O":
                                break
                            if arr[nrx][nry]==".":
                                rx=nrx
                                ry=nry

def oversize(x,y):
    if x<0 or x>=n or y<0 or y>=m:
        return False
    return True