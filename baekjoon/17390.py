import sys

input = sys.stdin.readline

n, q = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

acc = [0] * (n + 1)

for i in range(1, n + 1):
    acc[i] = acc[i - 1] + arr[i - 1]

for i in range(q):
    s, e = map(int, input().split())
    print(acc[e] - acc[s - 1])