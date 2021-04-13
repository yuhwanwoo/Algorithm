n=int(input())

chess_map=[]
bishop=[]

for i in range(n):
    chess_map.append(list(map(int, input().split())))
    for j in range(n):
        if chess_map[i][j]==1:
            bishop.append((i,j))
# print(bishop)
leng=len(bishop)
cnt=0

isused01=[0]*(n*2-1)
isused02=[0]*(n*2-1)

def fun(index,count):
    global cnt
    if index==leng:
        cnt=max(cnt,count)
        return

    x,y=bishop[index]
    if isused01[x+y] or isused02[x-y+n-1]:
        fun(index+1,count)
    else:
        isused01[x+y]=1
        isused02[x-y+n-1]=1
        fun(index+1,count+1)
        isused01[x+y]=0
        isused02[x-y+n-1]=0
        fun(index+1,count)

fun(0,0)
print(cnt)