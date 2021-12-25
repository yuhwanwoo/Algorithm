# https://welog.tistory.com/271

import sys
input = sys.stdin.readline

def union(a,b):
    A = find_parent(a)
    B = find_parent(b)
    if A != B:
        if rank[A] < rank[B]:
            A,B = B,A
        make_set[B] = A
        if rank[A] == rank[B]:
            rank[A] += 1

def find_parent(ind):
    if make_set[ind] == ind:
        return ind
    else:
        make_set[ind] = find_parent(make_set[ind])
        return make_set[ind]


N,M,K = map(int,input().split())


plant = list(map(int,input().split()))
make_set = [i for i in range(N+1)]
rank = [1 for _ in range(N+1)]
edges = []
for _ in range(M):
    u,v,w = map(int,input().split())
    edges.append((u,v,w))

edges.sort(key=lambda x : -x[2])


for k in range(1,K):
    union(plant[k],plant[k-1])

cnt = 1
result = 0
while cnt <(N-K+1):
    x,y,weight = edges.pop()
    if find_parent(x) != find_parent(y):
        union(x,y)
        result += weight
        cnt += 1

print(result)