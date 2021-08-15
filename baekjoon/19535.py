import sys

input = sys.stdin.readline

n = int(input())

lines = []
degree = [0] * (n + 1)

for i in range(n-1):
    s, e = map(int, input().split())
    lines.append((s, e))

    degree[s] += 1
    degree[e] += 1

d_cnt = 0
j_cnt = 0

# ㅈ 개수 구하기
for i in range(1, n + 1):
    j_cnt += degree[i] * (degree[i] - 1) * (degree[i] - 2) / 6 if degree[i] >= 3 else 0

for line in lines:
    dot1, dot2 = line
    d_cnt += ((degree[dot1] - 1) * (degree[dot2] - 1))

if d_cnt > 3 * j_cnt:
    print("D")
elif d_cnt < 3 * j_cnt:
    print("G")
else:
    print("DUDUDUNGA")