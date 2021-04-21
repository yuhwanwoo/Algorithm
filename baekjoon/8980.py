n,c=map(int,input().split())

box=[]
country=[c]*(n+1)

m=int(input())

for i in range(m):
    start,end,amount=map(int,input().split()) 
    box.append((start,end,amount))

box.sort(key=lambda x:int(x[1]))

answer=0

for i in range(m):
    temp=c
    for j in range(box[i][0], box[i][1]):
        temp=min(temp,country[j])
    temp=min(temp,box[i][2])
    for j in range(box[i][0], box[i][1]):
        country[j]-=temp
    answer+=temp

print(answer)