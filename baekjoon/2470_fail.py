n = int(input())
arr = list(map(int, input().split()))

answer = int(1e9)

ansi = 0
ansj = 0

for i in range(n - 1):
    for j in range(i + 1 , n):
        if abs(arr[i] + arr[j]) < abs(answer):
            answer = arr[i] + arr[j]
            ansi = arr[i]
            ansj = arr[j]

ans = [ansi, ansj]
ans.sort()
print(ansi, ansj)