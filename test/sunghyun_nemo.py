leng,totalSum,cnt=0,0,0
n,m=map(int,input().split())
mapp=[[0]*m  for _ in range(n) ]

#print(mapp)
leng=n*m
cnt=0

def dfs(index,num):
    global cnt
    if leng==index:
        return
    
    r=index//m
    c=index%m
    mapp[r][c]=num
    
    
    
    if(mapp[r][c]==1):
        mapp[r][c]=2
        print(mapp)
        mapp[r][c]=1
        if(r<n or r-1>=0 or c<m or c-1>=0):
            
            if mapp[r][c-1]==1 and mapp[r-1][c]==1 and mapp[r-1][c-1]==1:
                cnt+=1
                mapp[r][c]=2
                print(mapp)
                mapp[r][c]=1
    
    dfs(index+1,1)
    dfs(index+1,0)

dfs(0,1)
dfs(0,0)
totalSum=1<<leng
print(totalSum)
print(cnt)