leng,totalSum,cnt=0,0,0
n,m=map(int,input().split())
mapp=[[0]*(m)  for _ in range(n) ]

#print(mapp)
leng=n*m
cnt=0

def dfs(index,booln):
    global cnt
    if leng==index and booln==True :
        
        cnt+=1
        return
    elif leng==index:
    	return
    else:
        r=index//m
        c=index%m
        print(mapp)
        
        if booln==True:
    	    mapp[r][c]=1
    	    dfs(index+1,booln)
    	    mapp[r][c]=0
    	    dfs(index+1,booln)
        else:
            if r>=1 and c>=1:
                if mapp[r-1][c]==1 and mapp[r][c-1]==1 and mapp[r-1][c-1]==1 :
                    mapp[r][c]=1
                    dfs(index+1,True)
                    mapp[r][c]=0
                    dfs(index+1,False)
                else:
                    mapp[r][c]=1
                    dfs(index+1,False)
                    mapp[r][c]=0
                    dfs(index+1,False)
            else:
                mapp[r][c]=1
                dfs(index+1,False)
                mapp[r][c]=0
                dfs(index+1,False)
    

dfs(0,False)
totalSum=1<<leng

print(totalSum-cnt)