n=int(input())
data=list(map(int,input().split()))
data.sort()

target=1
for x in data: # 1 1 3
    # 만들 수 없는 금액을 찾았을 때 반복 종료
    #print(target)
    if target<x:
        break
    target=target+x


print(target)