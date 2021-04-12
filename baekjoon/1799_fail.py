n=int(input())

chess_map=[]

for i in range(n):
    chess_map.append(list(map(int, input().split())))

leng=n*n
cnt=0

isused01=[0]*(n*2-1)
isused02=[0]*(n*2-1)
print("=======================")
print(chess_map)
def fun(index,count):
    global cnt
    if leng<=index:
        cnt=max(cnt,count)
        return

    for i in range(leng):
        x=i//n
        y=i%n
        if isused01[x+y] or isused02[x-y+n-1]:
            continue
        if chess_map[x][y]==1:

            isused01[x+y]=1
            isused02[x-y+n-1]=1
            fun(index+1,count+1)
            
            isused01[x+y]=0
            isused02[x-y+n-1]=0
            continue
        if chess_map[x][y]==0:
            fun(index+1,count)
        # print("???????????")

    return

fun(0,0)
print(cnt)