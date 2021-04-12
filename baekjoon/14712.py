leng,cnt=0,0
n,m=map(int,input().split())
mapp=[[0]*(m+1)  for _ in range(n+1) ]

#print(mapp)
leng=n*m
cnt=0

def dfs(index):
    global cnt
    if leng==index:        
        cnt+=1
        return

    
    r=index//m+1
    c=index%m+1

    
    if mapp[r-1][c]==1 and mapp[r][c-1]==1 and mapp[r-1][c-1]==1:
        dfs(index+1)
    else:
        dfs(index+1)
        mapp[r][c]=1
        dfs(index+1)
        mapp[r][c]=0
    
    return

dfs(0)

print(cnt)