import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = max(arr)
answer = 0
while start <= end:
    mid = (start + end) // 2
    
    add = 0
    for ele in arr:
        if ele > mid:
            add += (ele - mid)
            if add > m:
                break
    
    if add < m:
        end = mid - 1
    else:
        answer = mid
        start = mid + 1

print(answer)