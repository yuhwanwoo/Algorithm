from collections import deque

r, c = map(int,input().split())

visited = [[False]*c for _ in range(r)]
arr = []
start = []

# 북 동 남 서
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

for i in range(r):
    arr.append(list(input()))
    for j in range(c):
        if arr[i][j] == "M" or arr[i][j] == "Z":
            start.append((i,j))
q=deque()

ax = 0
ay = 0

def bfs(q, visited):
    global ax, ay
    while q:
        x, y = q.popleft()
        visited[x][y] = True

        if arr[x][y] == '|':
            for i in [0,2]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))

        if arr[x][y] == '-':
            for i in [1,3]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':   
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))
        if arr[x][y] == '+':
            for i in [0,1,2,3]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))
        if arr[x][y] == '1':
            for i in [1,2]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))
        if arr[x][y] == '2':
            for i in [0,1]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))
        if arr[x][y] == '3':
            for i in [0,3]:
                nx = x + dx[i]
                ny = y + dy[i]
                if visited[nx][ny] == True:
                    continue
                if arr[nx][ny] == '.':
                    ax = nx
                    ay = ny
                else:
                    q.append((nx,ny))
        if arr[x][y] == '4':
            for i in [2,3]:
                nx = x + dx[i]
                ny = y + dy[i]
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
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= r or ny >= c:
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
if flag :
    for i in range(4):
        nx = ax + dx[i]
        ny = ay + dy[i]
        if nx < 0 or ny <0 or nx >= r or ny >= c:
            continue
        if
else:
    if start[0][0] == start[1][0]:
        pipe = "-"
    else:
        pipe = "|"
