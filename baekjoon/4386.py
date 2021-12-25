n=int(input())

stars=[]

for i in range(n):
    x,y=map(float,input().split())
    stars.append((x,y))

parent=[i for i in range(n)]

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

def dist(co,ct):
    x1,y1=co
    x2,y2=ct
    sd=((x2-x1)**2+(y2-y1)**2)**0.5
    return sd

dis=[]

for i in range(n-1):
    for j in range(i+1,n):
        dis.append((i,j,dist(stars[i],stars[j])))

dis.sort(key=lambda x:x[2])

result=0

for i in dis:
    s,e,d=i
    if find_parent(parent,s) != find_parent(parent,e) :
        union_parent(parent,s,e)
        result+=d

print(round(result, 2))