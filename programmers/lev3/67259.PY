from collections import deque

def solution(board):
    answer = int(1e9)

    MAX_VALUE = int(1e6)

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    size = len(board)
    co_board = [[MAX_VALUE] * size for _ in range(size)]

    q = deque()
    
    q.append((0,0,1,0))
    q.append((0,0,2,0))

    while q:
        cx, cy, c_dire, c_cost = q.popleft()
        
        if cx == size - 1 and cy == size -1:
            answer = min(answer, c_cost)
            continue

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            cost = 0
            if nx < 0 or ny < 0 or nx >= size or ny >= size or board[nx][ny] == 1:
                continue
            if c_dire + 2 == i or c_dire - 2 == i:
                continue
            if c_dire == i:
                cost = 100
            else:
                cost = 500 + 100
            if co_board[nx][ny] >= c_cost + cost:
                co_board[nx][ny] = c_cost + cost
                q.append((nx, ny, i, c_cost + cost))
            
    return answer

board=[[0,0,0,0,0,0],[0,1,1,1,1,0],[0,0,1,0,0,0],[1,0,0,1,0,1],[0,1,0,0,0,1],[0,0,0,0,0,0]]
solution(board)