import heapq

n, m = map(int, input().split())

arr = list(map(int, input().split()))

heapq.heapify(arr)

answer = 0

while arr:
    if m == 0:
        break

    cake = heapq.heappop(arr)

    if cake < 10:
        continue
    elif cake == 10:
        answer += 1
    else:
        mod = cake - 10
        answer += 1
        m -= 1
        if mod == 10:
            answer += 1
            continue
        heapq.heappush(arr, mod)

print(answer)