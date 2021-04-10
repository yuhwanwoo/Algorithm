import copy

leng,totalSum,cnt=0,0,0
n,m=map(int,input().split())
mapp=[[2]*m  for _ in range(n) ]

#print(mapp)
leng=n*m
cnt=0

def dfs(index,num):
    global cnt,mapp
    if leng==index:
        return
    
    r=index//m
    c=index%m
    mapp[r][c]=num
    
    print(mapp)


    if(r<n or r-1>=0 or c<m or c-1>=0):
        for i in range(1,n):
            judge=False
            for j in range(1,m):
                if mapp[i][j-1]==1 and mapp[i-1][j]==1 and mapp[i-1][j-1]==1 and mapp[i][j]==1:
                    cnt+=1
                    judge=True
                    break
            if judge:
                break


    temp=copy.deepcopy(mapp)    
    dfs(index+1,1)
    mapp=copy.deepcopy(temp)    
    dfs(index+1,0)


temp=copy.deepcopy(mapp)
dfs(0,1)
mapp=copy.deepcopy(temp)
dfs(0,0)
totalSum=1<<leng
print(cnt)
print(totalSum-cnt)