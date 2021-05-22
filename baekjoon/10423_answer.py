import sys
import heapq

input = sys.stdin.readline

N,M,K = map(int,input().split())

graph = [{} for i in range(N+1)]
plant = list(map(int,input().split()))
INF = float('inf')
for _ in range(M):
    u,v,w = map(int,input().split())
    graph[u][v] = min(graph[u].get(v,float('inf')),w)
    graph[v][u] = min(graph[v].get(u,float('inf')),w)



MST_DISTANCE = [INF for i in range(N+1)]
visited = [True]*(N+1)

result = 0
node_list = []
for start in plant:
    heapq.heappush(node_list,(0,start))
    MST_DISTANCE[start] = 0

while node_list:
    dis,node = heapq.heappop(node_list)
    if not visited[node]:
        continue
    result += dis
    visited[node] = False
    for next_node in graph[node]:
        if MST_DISTANCE[next_node] >graph[node][next_node]:
            MST_DISTANCE[next_node] = graph[node][next_node]
            heapq.heappush(node_list,(MST_DISTANCE[next_node],next_node))


print(result)