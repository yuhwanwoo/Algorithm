m=int(input())
num=list(map(int,input().split()))
add,sub,mul,div=map(int,input().split())

min_value=1e9
max_value=-1e9

def dfs(i,data):
    global add,sub,mul,div,min_value,max_value
    if i==m:
        min_value=min(min_value,data)
        max_value=max(max_value,data)
    else:
        if add>0:
            add-=1
            dfs(i+1,data+num[i])
            add+=1
        if sub>0:
            sub-=1
            dfs(i+1,data-num[i])
            sub+=1
        if mul>0:
            mul-=1
            dfs(i+1,data*num[i])
            mul+=1
        if div>0:
            div-=1
            dfs(i+1,int(data/num[i]))
            div+=1

dfs(1,num[0])

print(max_value)
print(min_value)