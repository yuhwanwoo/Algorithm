import sys
input = sys.stdin.readline
 
N, X, Y = map(int, input().split())
used = [False]*(N+1)
arr = [0]*(2*N+1)
used[Y-X-1] = True
arr[X] = Y-X-1
arr[Y] = Y-X-1
answer = 0
 
 
def dfs(x):
    global answer
    if x == 2*N+1:
        answer += 1
        return
    if arr[x] != 0:
        dfs(x+1)
    else:
        for j in range(1, len(used)):
            if not used[j] and x+j+1 < 2*N+1 and arr[x+j+1] == 0:
                used[j] = True
                arr[x] = j
                arr[x+j+1] = j
                dfs(x+1)
                used[j] = False
                arr[x] = 0
                arr[x+j+1] = 0
 
 
dfs(1)
print(answer)