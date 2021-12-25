
mv=[(2,-1),(2,1),(-2,1),(-2,-1),(1,2),(-1,2),(1,-2),(-1,-2)]



def move(x,y):
    cnt=0
    for i in mv:
        dx,dy=i
        nx=x+dx
        ny=y+dy
        if nx<0 or nx>=8 or ny<0 or ny>=8:
            continue
        cnt+=1
    return cnt

loc=input()
ans=move(ord(loc[0])-ord('a'),int(loc[1])-1)
print(ans)