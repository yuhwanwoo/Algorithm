from collections import deque

n, m = map(int, input().split())

arr = list(map(int, input().split()))

ten_mul = []

list1 = []

for i in arr:
    if i % 10 == 0:
        ten_mul.append(i)
    else:
        list1.append(i)

ten_mul.sort()
list1.sort()

arr = ten_mul + list1

arr = deque(arr)

answer = 0

while arr:
    if arr[0] == 10:
        answer += 1
        arr.popleft()
    elif arr[0] > 10:
        if m == 0:
            break
        m -= 1
        answer += 1
        arr[0] -= 10
    elif arr[0] < 10:
        arr.popleft()

print(answer)