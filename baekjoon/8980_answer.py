import sys

n, c = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())
box = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]


box.sort(key=lambda x:x[1])  # 도착 시간이 빠른 순서로 정렬



answer = 0  # 최대 박스 수
remain = [c] * (n + 1)  # 각 위치에 남은 공간

print(box)
print(remain)

for i in range(m):
    temp = c  # c개를 옮길 수 있다고 가정
    for j in range(box[i][0], box[i][1]):
        print(box[i][0], box[i][1], "box")
        temp = min(temp, remain[j])
    temp = min(temp, box[i][2])
    for j in range(box[i][0], box[i][1]):
        remain[j] -= temp
    answer += temp

print(answer)