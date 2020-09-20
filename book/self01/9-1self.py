import sys
input=sys.stdin.readline
INF=int(1e9)

# 노드의 개수, 간선의 개수를 입력받기
n,m=map(int,input().split())
# 시작노드 입력받기
start=int(input())

graph=[[] for _ in range(n+1)]

# 방문한 적이 있는지 체크하는 목적의 리스트 만들기
visited=[False]*(n+1)

distance=[INF]*len(n+1)

for _ in range(m):
    a,b,c=map(int,input().split())
    graph[a]=append((b,c))

def get_smallest_node():
    min_value=INF
    index=0 # 가장 최단 거리가 짧은 노드
    for i in range(1,n+1):
        if distance[i]<min_value and visited[i]=False:
            min_value=distance[i]
            index=i
    return index

def dijkstra(start):
    visited[start]=True
    distance[start]=0
    for j in range(graph[start]):
        distance[j]=j[1]
    for i in range(n-1):
        now=get_smallest_node()
        visited[now]=True
        for j in graph[now]:
            cost=distance[now]+j[1]
            if cost<distance[j[0]]:
                distance[j[0]]=cost
