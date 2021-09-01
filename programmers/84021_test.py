from collections import deque

def rot_arr(arr):
    size = len(arr)
    rotated_arr = [[0] * size for _ in range(size)]

    for i in range(size):
        for j in range(size):
            rotated_arr[j][size - i - 1] = arr[i][j]

    return rotated_arr

def judge(extention_map, m, n):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    # print("ex", extention_map)

    temp_size = len(extention_map) // 3
    flag = False
    for i in range(temp_size):
        for j in range(temp_size):
            if extention_map[m + i][n + j] == 3:
                return False
            if extention_map[m + i][n + j] == 2:
                flag = True
                for di in range(4):
                    nx = m + i + dx[di]
                    ny = n + j + dy[di]
                    if nx < 0 or ny < 0 or nx >= temp_size * 3 or ny >= temp_size * 3:
                            continue
                    if extention_map[nx][ny] == 0 or extention_map[nx][ny] == 3:
                        return False
    
    if flag == False:
        return False

    return True

def solution(game_board, table):
    answer = 0
    size = len(game_board)
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    temp_tables = []
    extention_map = [[1]*(size * 3) for _ in range(size * 3)]

    for i in range(size):
        for j in range(size):
            extention_map[size + i][size + j] = game_board[i][j]

    for i in range(size):
        for j in range(size):
            if table[i][j] == 1:
                temp_table = [[0] * size for _ in range(size)]
                block_loc = []
                q = deque()
                q.append((i, j))

                block_size = 0 # block size 저장을 위한 변수
                while q:
                    cx, cy = q.popleft()
                    block_loc.append((cx, cy))
                    block_size += 1
                    temp_table[cx][cy] = 2
                    table[cx][cy] = 0
                    for direction in range(4):
                        nx = cx + dx[direction]
                        ny = cy + dy[direction]
                        if nx < 0 or ny < 0 or nx >= size or ny >= size:
                            continue
                        if table[nx][ny] == 1:
                            q.append((nx, ny))
                            table[nx][ny] = 0
                # 여기 전까지 if문 안이 블록 추출까지 한 것 
                temp_tables.append((temp_table,block_size))
                # 다음은 추출한 블록으로 끼워보기
    
    for temp_tab in temp_tables:
        temp_table,block_size = temp_tab
        flag = False
        for _ in range(4):
            temp_table = rot_arr(temp_table)
            for m in range(1, size * 2 - 1):
                for n in range(1, size * 2 - 1):
                    for x in range(size):
                        for y in range(size):
                            extention_map[m + x][n + y] += temp_table[x][y]
                    
                    if judge(extention_map, m, n) == True:
                        # print(m, n)
                        # for v in extention_map:
                        #     print(v)
                        print("=====================")
                        for x in range(size):
                            for y in range(size):
                                if extention_map[m + x][n + y] == 2:
                                    extention_map[m + x][n + y] = 1
                        # print(answer, block_size,"|||  m, n :", m, n)
                        for v in extention_map:
                            print(v)
                        answer += block_size
                        flag = True
                    else:
                        for x in range(size):
                            for y in range(size):
                                extention_map[m + x][n + y] -= temp_table[x][y]
                    if flag:
                        break
                if flag:
                    break
            if flag:
                break


    return answer

game_board = [[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]
table = [[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]
# game_board = [[0,0,0],[1,1,0],[1,1,1]]
# table = [[1,1,1],[1,0,0],[0,0,0]]
#game_board = [[0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0], [1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0], [1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1], [0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0], [0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1], [0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0], [1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0], [0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0], [0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1], [0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0]]
#table = [[1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1], [1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1], [1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0], [0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0], [1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0], [1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0], [1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1], [1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1], [0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1], [1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1], [1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1], [1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1]]
print(solution(game_board, table))