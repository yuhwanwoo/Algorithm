import sys

input = sys.stdin.readline

arr = []

ones = []

cnt = [0] * 6
answer = 30

def sol(idx):
    global answer
    # print(idx)
    if idx == 100:  
        # print(idx)
        tmp = 0
        for i in range(1,len(cnt)):
            if cnt[i] > 5:
                tmp = -1
                break
            else:
                tmp += cnt[i]
        if tmp != -1:
            answer = min(answer, tmp)
        return
    
    x = idx // 10
    y = idx % 10

    if arr[x][y] == 1:
        for n in range(5,0,-1):
            if cnt[n] == 5:
                continue
            if x + n > 10 or y + n > 10:
                continue
            flag = False
            for i in range(n):
                for j in range(n):
                    if arr[x + i][y + j] != 1:
                        flag = True
                        break
                if flag:
                    break
            if not flag:
                for i in range(n):
                    for j in range(n):
                        arr[x + i][y + j] = 0
                cnt[n] += 1
                sol(idx+1)
                cnt[n] -= 1
                
                for i in range(n):
                    for j in range(n):
                        arr[x + i][y + j] = 1
    else:
        sol(idx+1)
    
    return

for i in range(10):
    arr.append(list(map(int, input().split())))

sol(0)

if answer == 30:
    print(-1)
else:
    print(answer)