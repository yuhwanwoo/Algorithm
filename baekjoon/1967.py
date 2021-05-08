import sys
sys.setrecursionlimit(10**9)

input=sys.stdin.readline

n=int(input())

result1=[0 for _ in range(n+1)]
result2=[0 for _ in range(n+1)]
tree=[[] for _ in range(n+1)]

def dfs(cur,result):
    for i in range(len(tree[cur])):
        end,dis=tree[cur][i]
        if result[end] == 0:
            result[end]=result[cur]+dis
            dfs(end,result)

for _ in range(n-1):
    a,b,c=map(int,input().split())
    tree[a].append((b,c))
    tree[b].append((a,c))

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