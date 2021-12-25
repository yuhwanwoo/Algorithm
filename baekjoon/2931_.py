from collections import deque

r, c = map(int,input().split())

def pip_list(pipe):
    if pipe == "|":
        return [0,2]
    if pipe == "-":
        return [1,3]
    if pipe == '+':
        return [0,1,2,3]
    if pipe == "1":
        return [1,2]
    if pipe == "2":
        return [0,1]
    if pipe == "3":
        return [0,3]
    if pipe == "4":
        return [2,3]

visited = [[False] * c for _ in range(r)]
arr = []
start = []

# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(r):
    arr.append(list(input()))
    for j in range(c):
        if arr[i][j] == "M" or arr[i][j] == "Z":
            visited[i][j] == True
            start.append((i,j))
q = deque()

ax = 0
ay = 0

def bfs(q, visited):
    global ax, ay
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        for i in pip_list(arr[x][y]):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= r or ny >= c or visited[nx][ny]:
                continue
            if arr[nx][ny] == "M" or arr[nx][ny] == "Z":
                continue
            if visited[nx][ny] == True:
                continue
            if arr[nx][ny] == '.':
                ax = nx
                ay = ny
            else:
                q.append((nx,ny))

flag=False

for s in start:
    x, y = s
    visited[x][y] = True
    # 북 동 남 서
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c or visited[nx][ny]:
            continue
        if arr[nx][ny] != '.':
            flag = True
            if i == 0 and (arr[nx][ny] == '|' or arr[nx][ny] == '+' or arr[nx][ny] == '1' or arr[nx][ny] == '4'):
                q.append((nx,ny))
            if i == 1 and (arr[nx][ny] == '-' or arr[nx][ny] == '+' or arr[nx][ny] == '3' or arr[nx][ny] == '4'):
                q.append((nx,ny))
            if i == 2 and (arr[nx][ny] == '|' or arr[nx][ny] == '+' or arr[nx][ny] == '2' or arr[nx][ny] == '3'):
                q.append((nx,ny))
            if i == 3 and (arr[nx][ny] == '-' or arr[nx][ny] == '+' or arr[nx][ny] == '1' or arr[nx][ny] == '2'):
                q.append((nx,ny))
            
    if flag :
        bfs(q,visited)
        break
pipe=""
direction = [False]*4
[False, False, False, False]
if flag :
    # 북0 동1 남2 서3
    for i in range(4):
        nx = ax + dx[i]
        ny = ay + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
            continue
        if i == 0 and (arr[nx][ny] == '|' or arr[nx][ny] == '+' or arr[nx][ny] == '1' or arr[nx][ny] == '4' ):
            direction[i] = True
        if i == 1 and (arr[nx][ny] == '-' or arr[nx][ny] == '+' or arr[nx][ny] == '3' or arr[nx][ny] == '4' ):
            direction[i] = True
        if i == 2 and (arr[nx][ny] == '|' or arr[nx][ny] == '+' or arr[nx][ny] == '2' or arr[nx][ny] == '3' ):
            direction[i] = True
        if i == 3 and (arr[nx][ny] == '-' or arr[nx][ny] == '+' or arr[nx][ny] == '1' or arr[nx][ny] == '2' ):
            direction[i] = True
    
    if direction[0] and direction[2] and not direction[1] and not direction[3]:
        pipe = "|"
    if direction[1] and direction[3] and not direction[0] and not direction[2]:
        pipe = "-"
    if direction[0] and direction[1] and direction[2] and direction[3]:
        pipe = "+"
    if direction[1] and direction[2] and not direction[0] and not direction[3]:
        pipe = "1"
    if direction[0] and direction[1] and not direction[2] and not direction[3]:
        pipe = "2"
    if direction[0] and direction[3] and not direction[1] and not direction[2]:
        pipe = "3"
    if direction[2] and direction[3] and not direction[0] and not direction[1]:
        pipe = "4"
else:
    if start[0][0] == start[1][0]:
        pipe = "-"
        ax = start[0][0]
        ay = (start[0][1] + start[1][1])//2
    else:
        pipe = "|"
        ax = (start[0][0] + start[1][0])//2
        ay = start[0][1]
print(ax+1,ay+1,pipe)