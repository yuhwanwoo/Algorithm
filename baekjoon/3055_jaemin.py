from collections import deque
# import sys

# input=sys.stdin.readline


def water(water_area, data):
    new = []
    for i in water_area:
        for j in range(4):
            nx = i[0] + dx[j]
            ny = i[1] + dy[j]

            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                continue

            if data[nx][ny] != 'X' and data[nx][ny] != 'D':
                data[nx][ny] = '*'
                new.append((nx, ny))
    return new

r, c = map(int, input().split())
data = []
water_area = []
x, y = 0, 0
for i in range(r):
    line = list(input())
    data.append(line)
    for j in range(len(line)):
        if line[j] == 'S':
            x = i
            y = j
        if line[j] == '*':
            water_area.append((i, j))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
result = [[0] * c for _ in range(r)]
ans = 0

q = deque()
q.append((x, y))
while q:
    now_x, now_y = q.popleft()
    if data[now_x][now_y] == 'D':
        ans = result[now_x][now_y]
        break
    water_area = water(water_area, data)
    for i in range(4):
        nx = now_x + dx[i]
        ny = now_y + dy[i]

        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            continue
        if data[nx][ny] != '*' and data[nx][ny] != 'X':
            result[nx][ny] = result[now_x][now_y] + 1
            q.append((nx, ny))
            print(result)
            
print(result)
if ans == 0:
    print('KAKTUS')
else:
    print(ans)