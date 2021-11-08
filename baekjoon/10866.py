from collections import deque
import sys

input = sys.stdin.readline

n = int(input())

q = deque()

for _ in range(n):
    com = list(input().split())
    size = len(q)
    if com[0] == 'push_back':
        q.append(com[1])
    elif com[0] == 'push_front':
        q.appendleft(com[1])
    elif com[0] == 'pop_front':
        if size == 0:
            print(-1)
        else:
            now = q.popleft()
            print(now)
    elif com[0] == 'pop_back':
        if size == 0:
            print(-1)
        else:
            now = q.pop()
            print(now)
    elif com[0] == 'size':
        print(size)
    elif com[0] == 'empty':
        if size == 0:
            print(1)
        else:
            print(0)
    elif com[0] == 'front':
        if size == 0:
            print(-1)
        else:
            print(q[0])
    else:
        if size == 0:
            print(-1)
        else:
            print(q[size - 1])
