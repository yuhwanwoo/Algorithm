

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

# 물고기 16마리를 돌려
def rot_fish(fish_map):
    for i in range(1,17):
        fx,fy=fish_map[i]
        for i in range(8):
            nx=fx+dire_map[(fx+i)%8]
            ny=fx+dire_map[(fy+i)%8]
            if fish_map[nx][ny] != 18 and nx>0 and ny<4 and ny>0 and ny<4:
                fish_map[nx][ny]=i
                
                break

def solution(x,y,num):
    if x<0 or y<0 or x>3 or y>3:
        return num
    fish_map[x][y]=18
    return 0

solution(0,0,fish_map[0][0])