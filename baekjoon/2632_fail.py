# 피자 원형이고 두 조각 이상을 자를때는 옆 조각을 잘라야 함
from itertools import combinations

sell=int(input())

# a,b 피자
a,b=map(int,input().split())

piece=[]

ab=a+b
for i in range(ab):
    piece.append(int(input()))

print(piece)

sum_piece=[]

for i in range(1,sell+1):
    sum_piece+=list(map(sum,combinations(piece,i)))

sum_piece.sort()

cnt=0

for i in sum_piece:
    if i==sell:
        cnt+=1

print(cnt)
