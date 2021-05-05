import sys

#n=int(input())

def dfs(index,cnt):
    visited[index]=True
    for i in arr[index]:
        if not visited[i]: 
            cnt=dfs(i,cnt+1)
    return cnt

for _ in range(int(sys.stdin.readline())):
    # x,y=map(int,input().split())
    x,y=map(int, sys.stdin.readline().split())
    arr=[[] for _ in range(x+1)]
    visited=[False]*(x+1)
    
    for j in range(y):
        gn,gm=map(int, sys.stdin.readline().split())
        arr[gn].append(gm)
        arr[gm].append(gn)
    
    cnt=dfs(1,0)
    print(cnt)