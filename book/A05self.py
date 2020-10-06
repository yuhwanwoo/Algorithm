from itertools import combinations

m,n=map(int,input().split())
number=list(map(int,input().split()))

num=dict()
for i in number:
    print(i)
    num[i]=num.get(i,[])+[1]

key_list=num.keys()

answer=len(list(combinations(number,2)))

print(answer)

for i in key_list:
    if len(num[i])>=2:
        answer-=len(list(combinations(num[i],2)))

print(num)
print(answer)