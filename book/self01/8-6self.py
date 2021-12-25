# 개미 전사
m=int(input())
stor=list(map(int,input().split()))

food=[0]*100

food[0]=stor[0]
food[1]=max(stor[0],stor[1])
for i in range(2,m):
    food[i]=max(food[i-1],food[i-2]+stor[i])

print(food[m-1])