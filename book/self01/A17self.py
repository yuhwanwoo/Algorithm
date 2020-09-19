from collections import deque
n,k=map(int,input().split())

graph=[]
data=[]
for i in range(n):
    graph.append(list(map(int,input().split())))


dx=[-1,1,0,0]
dy=[0,0,-1,1]


for i in range(n):
    for j in range(n):
        if graph[i][j]!=0:
            data.append((graph[i][j],i,j,0))
data.sort()
q=deque(data)

tarket_s,tarket_x,tarket_y=map(int,input().split())


while q:
    virus,x,y,s=q.popleft()
    if s==tarket_s:
       break
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<n:
            if graph[nx][ny]==0:
                graph[nx][ny]=virus
                q.append((graph[nx][ny],nx,ny,s+1))


print(graph[tarket_x-1][tarket_y-1])