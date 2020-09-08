from collections import deque

def solution(board):
    answer = 0

    
    # 가로일때 1
    # 세로일떄 0

    bfs(board,0,0,0,1,0)


    return answer

def bfs(board,x,y,a,b,dic):

    q=deque()
    q.append((x,y))
    q.append((a,b))
    
    while q:
        x,y=q.popleft()
        a,b=q.popleft()

        if dic==1:
            nx=


        if nx<0 and nx>len(board)-1 and ny<0 and ny>len(board)-1 and na<0 and na>len(board)-1 and nb<0 and nb>len(board)-1:
            continue
        if graph[nx][ny]==0
            graph[nx][ny]=graph[x][y]+2 # 일부로 2로함 나중에 2로 나눠야돼
            q.append((nx,ny))
        




board=[
    [0, 0, 0, 1, 1],
    [0, 0, 0, 1, 0],
    [0, 1, 0, 1, 1],
    [1, 1, 0, 0, 1],
    [0, 0, 0, 0, 0]
]

print(solution(board))