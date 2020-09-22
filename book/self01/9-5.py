import heapq
import sys

input=sys.stdin.readline
INF=int(1e9)

n,m,start=map(int,input().split())

graph=[[] for _ in range(n+1)]
distance=[INF]*(n+1)

for i in range(m):
    a,b,c=map(int,input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start]=0
    while q:
        dis,now=heapq.heappop(q)
        if distance[now]<dis:
            continue
        for i in graph[now]:
            cost=dis+i[1]
            if distance[i[0]]>cost:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

dijkstra(start)

cnt=0
max_dis=0
for i in distance:
    if i!=INF:
        cnt+=1
        max_dis=max(max_dis,i)

print(cnt-1,max_dis)