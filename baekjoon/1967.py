import sys
# https://xkdlaldfjtnl.tistory.com/43


input=sys.stdin.readline



n=int(input())

tree=[[] for _ in range(n+1)]

for _ in range(n-1):
    a,b,c=map(int,input().split())
    tree[a].append((b,c))
    tree[b].append((a,c))

print(tree)