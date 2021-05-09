import sys

input=sys.stdin.readline

n=int(input())

tree=[[] for _ in range(n+1)]
result1=[0 for _ in range(n+1)]
result2=[0 for _ in range(n+1)]

def dfs(cur,result):
    for i in range(len(tree[cur])):
        end,dis=tree[cur][i]
        if result[end] == 0:
            result[end]=result[cur]+dis
            dfs(end,result)

for i in range(n):
    arr=list(map(int,input().split()))
    start=arr[0]
    leng=len(arr)
    for i in range(1,leng,2):
        if arr[i]==-1:
            break
        else:
            tree[start].append((arr[i],arr[i+1]))

dfs(1,result1)
result1[1]=0
maxi=0
index=0

for i in range(len(result1)):
    if maxi<result1[i]:
        maxi=result1[i]
        index=i

dfs(index,result2)
result2[index]=0

print(max(result2))     