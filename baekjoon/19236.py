

# 1 2 3 4 5 6 7 8     ↑ 부터 1이고 반시계 방향임
dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,-1,-1,-1,0,1,1,1]

fish=dict()

fish_map=[[],[],[],[]]
dire_map=[[],[],[],[]]
for i in range(4):
    temp=list(map(int,input().split()))
    for j in range(len(temp)):
        if j%2==0:
            fish_map[i].append(temp[j])
            fish[temp[j]]=(i,j//2)
        if j%2==1:
            dire_map[i].append(temp[j])

print(fish_map)
print(dire_map)
print(fish)

def solution(x,y,num):
    
    return 0

solution(0,0,0)