n=int(input())
ans=0
def dfs(pos,visited,deep,hap):
    global ans
    if deep==11:
        ans=max(ans,hap)
        # print(ans)
        return
    for i in pos[deep]:
        score,po,pe=i
        if po==deep and not visited[pe]:
            visited[pe]=True
            dfs(pos,visited,deep+1,hap+score)
            visited[pe]=False
    return
while True:
    ans=0
    pos=[[] for _ in range(11)]
    
    arr=[]
    visited=[False]*11
    for i in range(11):
        arr.append(list(map(int,input().split())))
        for j in range(11):
            if arr[i][j]!=0:
                pos[j].append((arr[i][j],j,i))
    # print(pos)
    dfs(pos,visited,0,0)
    print(ans)
    n-=1
    if n==0:
        break
