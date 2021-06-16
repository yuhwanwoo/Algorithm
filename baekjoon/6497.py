import sys

input=sys.stdin.readline

def find_parent(parent,x):
    if parent[x] !=x:
        return find_parent(parent,parent[x])
    return x

def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a<b:
        parent[b]=a
    else:
        parent[a]=b

while True:
    m,n=map(int,input().split())
    if m==0 and n==0:
        break
    
    parent=list(range(m))
    result=0
    edges=[]

    for _ in range(n):
        a, b, cost = map(int, input().split())
        edges.append((cost, a, b))

    edges.sort()

    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
        else:
            result += cost

    print(result)