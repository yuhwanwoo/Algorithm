n=int(input())


cnt=0
def dfs(num):
    global cnt
    if len(str(num))==n:
        cnt+=1
        return
    num=str(num)
    front=num[:-1]
    back=num[-1]
    if int(back)>0 and int(back)<9:
        dfs(front+back+str(int(back)+1))
        dfs(front+back+str(int(back)-1))
    if int(back)==0:
        dfs(front+back+str(int(back)+1))
    if int(back)==9:
        dfs(front+back+str(int(back)-1))


for i in range(1,10):
    dfs(i)

print(cnt%1000000000)