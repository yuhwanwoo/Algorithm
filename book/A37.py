INF=int(e99)

# 노드의 개수 및 간선의 개수를 입력받기
n=int(input())
m=int(input())
# 2차원 리스트(그래프 표현)를 만들고, 모든 값을 무한으로 초기화
graph=[[INF]*(n+1) for _ in range(n+1)]

# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for i in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b]=0

for _ in range(m):
    a,b,c=map(int,input().split())
    # 가장 짧은 간선 정보만 저장
    if c<graph[a][b]:
        graph[a][b]=c

for i in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

# 수행된 결과를 출력
for a in range(1,n+1):
    for b in range(1,n+1):
        # 도달할 수 없는 경우, 0을 출력
        if graph[a][b]==INF:
            print(0,end=" ")
        else:
            print(graph[a][b],end=" ")
    print()