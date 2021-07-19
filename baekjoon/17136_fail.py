arr = []

ones = []
visited = [[False] * 10 for _ in range(10)]

cnt = [0] * 6

def judge(x,y,n):
    global visited
    flag = False
    for i in range(n):
        for j in range(n):
            if x + i >= 10 or y + j >=10:
                flag = True
                break
            if arr[x + i][y + j] != 1:
                flag = True
                
                break
            visited[x + i][y + j] = True
        if flag:
            break
    if flag :
        for i in range(n):
            for j in range(n):
                if x + i >= 10 or y + j >=10:
                    continue
                visited[x + i][y + j] = False
        
        return False
    print(visited)
    return True

for i in range(10):
    arr.append(list(map(int, input().split())))
    for j in range(10):
        if arr[i][j] == 1:
            ones.append((i,j))

for i in ones:
    x, y = i
    if visited[x][y] == True:
        continue
    print(x,y)
    for j in range(5,0,-1):
        if judge(x,y,j):
            cnt[j] +=1
            break

print(cnt)