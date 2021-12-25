import copy
from collections import deque

n,m=map(int,input().split())

room=[]
camera=[]

dx=[1,0,-1,0]
dy=[0,-1,0,1]

for i in range(n):
    room.append(list(map(str,input().split())))
    for j in range(m):
        if room[i][j]=="1" or room[i][j]=="2" or room[i][j]=="3" or room[i][j]=="4" or room[i][j]=="5" :
            camera.append((i,j))

def observe(temp,camera_num,x,y,i):
    tx=x
    ty=y
    ti=i
    if camera_num=="1":
        while True:
            nx=x+dx[ti]
            ny=y+dy[ti]
            if nx>=n or 0>nx or ny>=m or 0>ny or temp[nx][ny]=="6":
                break
            if temp[nx][ny]=="1" or temp[nx][ny]=="2" or temp[nx][ny]=="3" or temp[nx][ny]=="4" or temp[nx][ny]=="5":
                x=nx
                y=ny
                continue
            temp[nx][ny]="#"
            x=nx
            y=ny
    if camera_num=="2" or camera_num=="3":
        for j in range(2):
            tx=x
            ty=y
            while True:
                nx=tx+dx[ti]
                ny=ty+dy[ti]
                if nx>=n or 0>nx or ny>=m or 0>ny or temp[nx][ny]=="6":
                    break
                if temp[nx][ny]=="1" or temp[nx][ny]=="2" or temp[nx][ny]=="3" or temp[nx][ny]=="4" or temp[nx][ny]=="5":
                    tx=nx
                    ty=ny
                    continue
                temp[nx][ny]="#"
                tx=nx
                ty=ny
            if camera_num=="2":
                ti=(ti+2)%4
            if camera_num=="3":
                ti=(ti+1)%4
    if camera_num=="4":
        for j in range(3):
            tx=x
            ty=y
            while True:
                nx=tx+dx[ti]
                ny=ty+dy[ti]
                if nx>=n or 0>nx or ny>=m or 0>ny or temp[nx][ny]=="6":
                    break
                if temp[nx][ny]=="1" or temp[nx][ny]=="2" or temp[nx][ny]=="3" or temp[nx][ny]=="4" or temp[nx][ny]=="5":
                    tx=nx
                    ty=ny
                    continue
                temp[nx][ny]="#"
                tx=nx
                ty=ny
            ti=(ti+1)%4
    if camera_num=="5":
        for j in range(4):
            tx=x
            ty=y
            while True:
                nx=tx+dx[ti]
                ny=ty+dy[ti]
                if nx>=n or 0>nx or ny>=m or 0>ny or temp[nx][ny]=="6":
                    
                    break
                if temp[nx][ny]=="1" or temp[nx][ny]=="2" or temp[nx][ny]=="3" or temp[nx][ny]=="4" or temp[nx][ny]=="5":
                    tx=nx
                    ty=ny
                    
                    continue
                temp[nx][ny]="#"
                
                tx=nx
                ty=ny
            ti=(ti+1)%4

    return temp

cnt_n=int(1e9)

# 맵 복사하고 카메라 첫번째 거 쓰고 복사한 맵에 깔고
# 다음 카메라 

# n은 n번째 카메라
def solution(room,index):
    global cnt_n
    if index>=len(camera):
        cnt=0
        for i in range(n):
            for j in range(m):
                if room[i][j]=="0":
                    cnt+=1
        cnt_n=min(cnt_n,cnt)
        return None
    

    x,y=camera[index]
    
    for i in range(4):
        tx=x
        ty=y
        temp=copy.deepcopy(room)
        if room[tx][ty]=="1" or room[tx][ty]=="2" or room[tx][ty]=="3" or room[tx][ty]=="4" or room[tx][ty]=="5":
            ## 감시 확인
            temp=observe(temp,room[tx][ty],tx,ty,i)

            # 감시 한 상태로 temp돌리기
            solution(temp,index+1)


    return 0

solution(room,0)
print(cnt_n)
    # if n>=len(camera):

    #     return None
    # for i in range(4):
    #     temp=copy.deepcopy(room)
    #     if room[x][y]==1 or room[x][y]==2 or room[x][y]==3 or room[x][y]==4 or room[x][y]==5:
    #         observe(temp,room[x][y])
    #         cnx,cny=camera.pop(0)
    #         solution(temp,cnx,cny,n+1)
        
