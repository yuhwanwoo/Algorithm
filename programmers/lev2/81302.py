from collections import deque

def judge(place):
    people = deque()
    dx = [-1,-1,0,1,1,1,0,-1]
    dy = [0,-1,-1,-1,0,1,1,1]
    for i in range(5):
        for j in range(5):
            if place[i][j] == "P":
                people.append((i, j))
    while people:
        x,y = people.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= 5 or ny >= 5:
                continue
            if i == 0 or i == 2 or i == 4 or i == 6:
                if place[nx][ny] == "P":
                    return False
                else:
                    nnx = nx + dx[i]
                    nny = ny + dy[i]
                    if nnx < 0 or nny < 0 or nnx >= 5 or nny >= 5:
                        continue
                    if place[nnx][nny] == "P" and place[nx][ny] == "O":
                        return False

            if place[nx][ny] == "P":
                if i == 1:
                    if place[x - 1][y] == "O" or place[x][y - 1] == "O":
                        return False
                if i == 3:
                    if place[x + 1][y] == "O" or place[x][y - 1] == "O":
                        return False
                if i == 5:
                    if place[x + 1][y] == "O" or place[x][y + 1] == "O":
                        return False
                if i == 7:
                    if place[x - 1][y] == "O" or place[x][y + 1] == "O":
                        return False
    return True

def solution(places):
    answer = []
    for place in places:
        if judge(place):
            answer.append(1)
        else:
            answer.append(0)
    
    return answer