# pypy만 되네...
import sys
input = sys.stdin.readline

n=int(input())

arr=[]

for i in range(n):
	arr.append(list(map(int,input().split())))
bigger=arr[0]
small=arr[0]


for i in range(1,n):
	bigger=[max(bigger[0],bigger[1])+arr[i][0], max(bigger[0],bigger[1],bigger[2])+arr[i][1],max(bigger[1],bigger[2])+arr[i][2]]
	small=[min(small[0],small[1])+arr[i][0], min(small[0],small[1],small[2])+arr[i][1],min(small[1],small[2])+arr[i][2]]

print(max(bigger),min(small))