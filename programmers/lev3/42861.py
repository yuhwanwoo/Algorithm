# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, costs):
    answer = 0
    parent = [0] * (n) # 부모 테이블 초기화하기

    # 모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    edges = []
    result = 0

    # 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for i in range(n):
        parent[i] = i
    
    for i in costs:
        a,b,cost=i
        edges.append((cost,a,b))
    edges.sort()

    for edge in edges:
        cost,a,b,=edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost
    answer=result
    return answer

n=4
costs=[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]

solution(n,costs)