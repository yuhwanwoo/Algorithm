
dx=[0,1,0,-1]
dy=[1,0,-1,0]

def solution(arr,n,dire):
    length=len(arr)
    if dire==0:
        x=0
        y=0
    elif dire==1:
        x=0
        y=length-1
    elif dire==2:
        x=length-1
        y=length-1
    else:
        x=length-1
        y=0
    cnt=0
    while cnt<length:
        
        for i in range(length-2):
            nx=x+dx[dire]
            ny=y+dy[dire]
            print(nx,ny)
            if arr[x][y]==arr[nx][ny]:
                arr[x][y]+=arr[nx][ny]
                arr[nx][ny]=0
        x=x+dx[(dire+1)//4]
        y=y+dy[(dire+1)//4]
        cnt+=1
    print(arr)

    return max_count

n=int(input())


arr=[]

for _ in range(n):
    arr.append(input().split())

max_num=0

for i in range(4):
    max_num=max(max_num,solution(arr,0,i))
    break



print(arr)