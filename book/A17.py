from collections import deque

n,k=map(int,input().split())

graph=[] # 전체 보드 정보를 담는 리스트
data=[] # 바이러스에 대한 정보를 담는 리스트

for i in range(n):
    # 보드 정보를 한 줄 단위로 입력
    graph.append((list(map(int,input().split()))))
    for j in range(n):
        # 해당 위치에 바이러스가 존재하는 경우
        if graph[i][j]!=0:
            # (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
            data.append((graph[i][j],0,i,j))

# 정렬 이후에 큐로 옮기기(낮은 번호의 바이러스가 먼저 증식하므로)
data.sort()
q=deque(data)

target_s,target_x,target_y=map(int,input().split())

# 바이러스가 퍼져나갈 수 있는 4가지 위치
dx=[-1,0,1,0]
dy=[0,1,0,-1]

# 너비 우선 탐색(BFS) 진행
while q:
    virus,s,x,y=q.popleft()
    if s==target_s:
        break
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if n>=0 and nx<n and ny>=0 and ny<n:
            if graph[nx][ny]==0:
                graph[nx][ny]=virus
                q.append((graph[nx][ny],s+1,nx,ny))

print(graph[target_x-1][target_y-1])
