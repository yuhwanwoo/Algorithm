import heapq

INF=int(1e9)

def dijkstra(start,graph,distance):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        print(q)
        dist,now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

def solution(N, road, K):
    distance=[INF]*(N+1)
    answer = 0
    graph=[[] for i in range(N+1)]
    
    for i in road:
        a,b,c=i
        graph[a].append((b,c))
        graph[b].append((a,c))


    dijkstra(1,graph,distance)
    for i in distance:
        if i<=K:
            answer+=1
    print(distance)
    return answer

N=5
road=[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]
K=3
solution(N,road,K)