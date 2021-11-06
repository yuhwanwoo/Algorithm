n = int(input())
arr = list(map(int, input().split()))

def dfs(arr, k, cnt):
    if cnt == k + 2:
        return arr
    
    arr = dfs(arr[-2**(k - cnt + 1) :], k, cnt + 1) + arr[:-2**(k - cnt + 1)]

    return arr

ansi = 0
ansj = 0
for i in range(1, n):
    result = list(range(1, n + 1))
    result = dfs(result, i, 1)

    flag = False
    for j in range(1, n):
        result = dfs(result, j, 1)
        # print(i, j, result)
        if result == arr:
            ansi = i
            ansj = j
            flag = True
            break
    if flag:
        break

print(i, j)