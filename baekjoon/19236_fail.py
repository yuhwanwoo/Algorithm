

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
    fish.keys().sort()
    for i in fish.keys():
        fx,fy=fish_map[i]
        for i in range(8):
            nx=fx+dx[dire_map[fx]-1+i]
            ny=fy+dy[dire_map[fy]-1+i]
            if fish_map[nx][ny] != 18 and nx>0 and ny<4 and ny>0 and ny<4:
                # 원래 내값
                temp_x,temp_y=fx,fy
                temp=fish_map[fx][fy]
                temp_dir=dire_map[fx][fy]
                # 원래 자리에 있던애 내 자리로
                
                fish_map[fx][fy]=fish_map[nx][ny]
                dire_map[fx][fy]=dire_map[nx][ny]
                fish_map[nx][ny]=temp
                dire_map[nx][ny]=temp_dir

                
                break

def solution(x,y,num):
    if x<0 or y<0 or x>3 or y>3:
        return num
    eaten=fish_map[x][y]
    del fish[eaten]
    fish_map[x][y]
    return 0

solution(0,0,fish_map[0][0])