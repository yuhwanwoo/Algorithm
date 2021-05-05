import sys
input=sys.stdin.readline

n,m=map(int,input().split())
s=[]

for i in range(n):
    s.append(input())

answer=0

for i in range(m):
    string=input()
    if string in s:
        answer+=1

print(answer)