import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

size = len(arr)
pre_sum = [0] * size

pre_sum[0] = arr[0]

for i in range(1, size):
    pre_sum[i] = pre_sum[i - 1] + arr[i]
pre_sum = [0] + pre_sum

for _ in range(m):
    i, j = map(int, input().split())
    print(pre_sum[j] - pre_sum[i - 1])