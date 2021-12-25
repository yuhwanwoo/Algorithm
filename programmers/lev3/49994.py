from collections import deque

def simul(top,ans,x,y):
    temp=[]
    
    if top=="U":
        nx=x
        ny=y+1
    if top=="D":
        nx=x
        ny=y-1
    if top=="R":
        nx=x+1
        ny=y
    if top=="L":
        nx=x-1
        ny=y
    if ny<-5 or ny>5 or nx<-5 or nx>5:
        return (x,y)
    else:
        temp.append((x,y))
        temp.append((nx,ny))
        temp.sort()
        ans.add((temp[0],temp[1]))
        print(ans,x,y)
        return (nx,ny)
        
def solution(dirs):
    answer = 0
    ans=set()
    dirs=deque(list(dirs))
    
    x,y=0,0

    for i in range(len(dirs)):
        top=dirs.popleft()
        
        nx,ny=simul(top,ans,x,y)
        x=nx
        y=ny
    print(ans)
    print(len(ans))
    return len(ans)

#dirs="ULURRDLLU"
dirs="LULLLLLLU"
solution(dirs)