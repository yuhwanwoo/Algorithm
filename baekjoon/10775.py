g=int(input())
p=int(input())

arr=[]

for i in range(p):
    n=int(input())
    arr.append(n)

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

parent=[i for i in range(g+1)]

answer=0

for i in arr:
    x=find_parent(parent,i)
    if x==0:
        break
    union_parent(parent,x,x-1)
    answer+=1

print(answer)