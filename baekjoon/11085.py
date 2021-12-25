import heapq

p,w=map(int,input().split())
c,v=map(int,input().split())

parent=list(range(p))

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

graph=[]

for i in range(w):
    s,e,width=map(int,input().split())
    heapq.heappush(graph,(-width,s,e))

answer=0

while graph:
    wid,s,e=heapq.heappop(graph)
    wid=-wid
    union_parent(parent,s,e)

    if find_parent(parent,c)==find_parent(parent,v):
        answer=wid
        break

print(answer)