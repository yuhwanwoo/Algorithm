from collections import deque

n, m = map(int, input().split())

indegree = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]
dic = dict()

for i in range(m):
    arr = list(map(int, input().split()))


L = int(input())

_list = list(map(int,input().split()))