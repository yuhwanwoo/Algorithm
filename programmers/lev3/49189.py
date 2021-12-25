# 가장 먼 노드
import heapq
import sys
input=sys.stdin.readline

def dijkstra(start,edge):
    INF=int(1e9)
    distance=[INF]*(len(edge)+1)
    graph=[[] for _ in range(len(edge)+1)]

    for i in range(len(edge)):
        a,b=edge[i]
        graph[a].append((b,1))
        graph[b].append((a,1))

    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dist,now=heapq.heappop(q)
        if distance[now]<dist:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
    remove_set={INF}

    distance=[i for i in distance if i not in remove_set]
    maxi=max(distance)
    cnt=0
    for i in distance:
        if maxi==i:
            cnt+=1
    return cnt

        
def solution(n, edge):
    answer=0
    
    
    answer=dijkstra(1,edge)
    return answer

n=6
edge=[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
solution(n,edge)