import copy

leng,totalSum,cnt=0,0,0
n,m=map(int,input().split())
mapp=[[2]*m  for _ in range(n) ]

#print(mapp)
leng=n*m
cnt=0

def dfs(index,num,booln):
    global cnt
    if leng==index and booln==True:
        cnt+=1
        return
    if leng==index:
        return
    
    r=index//m
    c=index%m
    mapp[r][c]=num
    
    # print(mapp)

    if not booln:
        for i in range(1,n):
            judge=False
            for j in range(1,m):
                if mapp[i][j-1]==1 and mapp[i-1][j]==1 and mapp[i-1][j-1]==1 and mapp[i][j]==1:
                    booln=True
                    judge=True
                    break
            if judge:
                break




dfs(0,1,False)
dfs(0,0,False)
totalSum=1<<leng
print(cnt)
print(totalSum-(cnt))