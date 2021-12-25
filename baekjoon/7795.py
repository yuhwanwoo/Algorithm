import sys
import bisect

input = sys.stdin.readline

t = int(input())

while t:

    cnt = 0

    n, m = map(int, input().split())

    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    
    A.sort()
    B.sort()

    for i in A:
        cnt += bisect.bisect_left(B, i)
    
    print(cnt)
    t-=1