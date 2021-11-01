import sys

input = sys.stdin.readline

n = int(input())

arr = []

for i in range(n):
    num = int(input())
    arr.append(num)

answer = 0
visited = [0] * 1000001

for i in range(n):
    now = arr[i]
    if visited[now] != 0:
        continue
    cnt = 0
    prev = -1
    for j in range(n):
        if arr[j] == now:
            continue
        if arr[j] != prev:
            prev = arr[j]
            cnt = 1
        else:
            cnt += 1
        answer = max(cnt, answer)
        
print(answer)