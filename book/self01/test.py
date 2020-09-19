from collections import deque
m,n=map(int,input().split())

graph=[]
data=[]
for i in range(m):
    graph.append(list(map(int,input().split())))
    for j in range(m):
        if graph[i][j]!=0:
            data.append((graph[i][j],i,j,0))

sec,c,d=map(int,input().split())

dx=[-1,1,0,0]
dy=[0,0,-1,1]

data.sort()
q=deque(data)
answer=0
while q:
    virus,x,y,s=q.popleft()
    if s==sec:
        answer=graph[c-1][d-1]
        break
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<m and ny>=0 and ny<m:
            if graph[nx][ny]==0:
                graph[nx][ny]=virus
                q.append((virus,nx,ny,s+1))
print(answer)