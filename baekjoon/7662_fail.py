import heapq
import sys

input=sys.stdin.readline

n=int(input())

nheap=[]
xheap=[]

for i in range(n):
    m=int(input())
    for j in range(m):
        cmd,n=input().split()
        if cmd=="I":
            heapq.heappush(nheap,int(n))
            heapq.heappush(xheap,-int(n))
        elif cmd=='D':
            if len(nheap)==0:
                continue
            elif n=='-1':
                temp=heapq.heappop(nheap)
                xheap.remove(-temp)
            else:
                temp=heapq.heappop(xheap)
                nheap.remove(-temp)
    if len(nheap)==0:
        print("EMPTY")
    elif len(nheap)==1:
        temp=heapq.heappop(nheap)
        print(temp,temp)
    else:
        big=-heapq.heappop(xheap)
        small=heapq.heappop(nheap)
        print(big,small)