import heapq

INF = int(1e9)

def dijkstra(start, end, graph, n):
    
    distance = [INF] * (n + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue
        
        for i in graph[now]:
            nnode, ndist = i
            cost = dist + ndist
            if cost < distance[nnode]:
                distance[nnode] = cost
                heapq.heappush(q, (cost, nnode))
    
    return distance[end]



def solution(n, s, a, b, fares):

    answer = INF

    graph = [[] * (n + 1) for _ in range(n + 1)]

    for i in fares:
        st, en, cost = i
        graph[st].append((en, cost))
        graph[en].append((st, cost))
    
    for i in range(1, n + 1):
        answer = min(answer, dijkstra(s, i, graph, n) + dijkstra(i, a, graph, n) + dijkstra(i, b, graph, n))
    
    # print(answer)
    return answer

n = 6
s = 4
a = 6
b = 2
fares = [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
solution(n, s, a, b, fares)