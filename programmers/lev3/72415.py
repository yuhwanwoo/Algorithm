import deque

def solution(board, r, c):
    answer = 0

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    q = deque()
    q.append((r,c))

    while q:
        cx, cy = q.popleft()
        for i in range(4):
            while True:
                nx = cx + dx[i]
                ny = cy + dy[i]
                if nx < 0 or ny < 0 or nx >= 4 or ny >= 4:
                    nx = cx - dx[i]
                    ny = cy - dy[i]
                    q.append((nx, ny))
                    break
                

        

    return answer

board = [[1,0,0,3],[2,0,0,0],[0,0,0,2],[3,0,1,0]]	
r = 1
c = 0
solution(board, r, c)