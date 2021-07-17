from collections import deque
import sys

input = sys.stdin.readline

t = int(input())

while t:
    n = int(input())

    store = []
    visited = [False] * (n+2)
    q = deque()

    x,y = map(int,input().split())

    q.append((x,y))

    for i in range(n):
        tx,ty = map(int,input().split())
        store.append((tx,ty))
    
    ex, ey = map(int, input().split())
    flag = False
    size = len(store)
    while q:
        cx, cy = q.popleft()

        if abs(cx - ex) + abs(cy - ey) <= 1000:
            flag = True
            break
        for i in range(size):
            if not visited[i] and abs(cx - store[i][0]) + abs(cy - store[i][1]) <= 1000:
                visited[i] = True
                q.append((store[i][0], store[i][1]))
    if flag :
        print("happy")
    else:
        print("sad")
    
    t-=1