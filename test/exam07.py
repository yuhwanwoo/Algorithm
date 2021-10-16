import deque

def solution(grid):
    answer = []

    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]

    q = deque()

    q.append((0,0))
    row = len(grid)
    column = len(grid[0])
    answer = set()


    while q:
        cx, cy = q.popleft()

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if nx <= 0 or ny <= 0:
                tmp = (cx, cy, i)
                if tmp in answer:
                    
                    break


    return answer


grid = ["SL","LR"]
solution(grid)