import sys
input=sys.stdin.readline
m,n=map(int,input().split())

graph=[]
temp=[[0]* n for _ in range(m)]

dx=[-1,1,0,0]
dy=[0,0,-1,1]

result=0

for i in range(m):
    graph.append(list(map(int,input().split())))



def virus(x,y):
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<m and ny>=0 and ny<n:
            if temp[nx][ny]==0:
                temp[nx][ny]=2
                virus(nx,ny)


def get_score():
    count=0
    for i in range(m):
        for j in range(n):
            if temp[i][j]==0:
                count+=1
    return count



def dfs(cnt):
    global result
    if cnt==3:
        for i in range(m):
            for j in range(n):
                temp[i][j]=graph[i][j]
        for i in range(m):
            for j in range(n):
                if temp[i][j]==2:
                    virus(i,j)
        result=max(result,get_score())
        return
    for i in range(m):
        for j in range(n):
            if graph[i][j]==0:
                graph[i][j]=1
                cnt+=1
                dfs(cnt)
                graph[i][j]=0
                cnt-=1


dfs(0)
print(result)
