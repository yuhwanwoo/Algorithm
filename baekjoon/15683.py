import copy
from collections import deque

n,m=map(int,input().split())

room=[]
camera=deque()

dx=[1,0,-1,0]
dy=[0,-1,0,1]

for i in range(n):
    room.append(list(map(int,input().split())))
    for j in range(m):
        if room[i][j]!=0:
            camera.append((i,j))

def observe(temp,camera_num,x,y,i):

    if camera_num==1:
        while True:
            nx=x+dx[i]
            ny=y+dy[i]
            


    return 0


# 맵 복사하고 카메라 첫번째 거 쓰고 복사한 맵에 깔고
# 다음 카메라 

# n은 n번째 카메라
def solution(room):

    while camera:
        x,y=camera.popleft()

        for i in range(4):
            temp.deepcopy(room)
            if room[x][y]==1 or room[x][y]==2 or room[x][y]==3 or room[x][y]==4 or room[x][y]==5:
                observe(temp,room[x][y],x,y,i)
                solution(temp)

    
    return 0

print(room)
print(camera)


    # if n>=len(camera):

    #     return None
    # for i in range(4):
    #     temp=copy.deepcopy(room)
    #     if room[x][y]==1 or room[x][y]==2 or room[x][y]==3 or room[x][y]==4 or room[x][y]==5:
    #         observe(temp,room[x][y])
    #         cnx,cny=camera.pop(0)
    #         solution(temp,cnx,cny,n+1)
        
