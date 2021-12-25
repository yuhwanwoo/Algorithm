import heapq
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = []

def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_find(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

parent = [i for i in range(n + 1)]

graph = []
answer = 0

for i in range(m):
    s, e, c = map(int, input().split())
    heapq.heappush(graph, (-c, s, e))

start, end = map(int, input().split())

while graph:
    now_c, now_s, now_e = heapq.heappop(graph)
    
    union_find(parent, now_s, now_e)
    if find_parent(parent, start) == find_parent(parent, end):
        answer = -now_c
        break

print(answer)