n, m = map(int, input().split())
arr = list(map(int, input().split()))

INF = int(1e9)

s = 0
end = min(arr) * m

while s <= end:
    mid = (s + end) // 2
    cnt = 0
    for i in range(n):
        cnt += (mid // arr[i])
    if cnt >= m:
        end = mid -1
    else:
        s = mid + 1

print(end + 1)