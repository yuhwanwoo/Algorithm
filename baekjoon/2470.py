n = int(input())
arr = list(map(int, input().split()))

answer = int(1e9)


# sort한다음 접근하기

start = 0
end = 1

while True:
    tmp = arr[start] + arr[end]
    if abs(tmp) < abs(answer):
        