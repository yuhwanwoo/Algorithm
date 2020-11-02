from itertools import combinations

n,m=map(int,input().split())
chicken,house=[],[]

for r in range(n):
    data=list(map(int, input().split()))
    for c in range(n):
        if data[c]==1:
            house.append((r,c)) # 일반 집
        elif data[c]==2:
            chicken.append((r,c)) # 치킨집

candidates=list(combinations(chicken,m))

def get_sum(candidate):
    result=0
    for hx,hy in house:
        # 가장 가까운 치킨집을 찾기
        temp=1e9
        for cx,cy in candidate:
            temp=min(temp,abs(hx-cx)+abs(hy-cy))
        # 가장 가까운 치킨집까지의 거리를 더하기
        result+=temp
    return result

result=1e9
for candidate in candidates:
    result=min(result,get_sum(candidate))

print(result)