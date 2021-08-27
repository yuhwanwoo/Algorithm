from collections import deque

def rot_arr(arr):
    size = len(arr)
    rotated_arr = [[0] * size for _ in range(size)]

    for i in range(size):
        for j in range(size):
            rotated_arr[j][size - i - 1] = arr[i][j]

    return rotated_arr

def solution(game_board, table):
    answer = -1
    size = len(game_board)
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    temp_table = [[0] * size for _ in range(size)]

    for i in range(size):
        for j in range(size):
            if table[i][j] == 1:
                q = deque()
                q.append((i, j))
                while q:
                    cx, cy = q.popleft()
                    temp_table[cx][cy] = 1
                    for direction in range(4):
                        nx = cx + dx[direction]
                        ny = cy + dy[direction]
                        if nx < 0 or ny < 0 or nx >= size or ny >= size:
                            continue
                        if table[nx][ny] == 1:
                            q.append((nx, ny))
                            table[nx][ny] = 0
    print(table)
    print(temp_table)

    return answer

game_board = [[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]
table = [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]
solution(game_board, table)