n=int(input())

arr=[]
for i in range(n):
    arr.append(int(input()))

front=arr[0]
lcnt=1
for i in range(1,n):
    if arr[i]>front:
        front=arr[i]
        lcnt+=1

front=arr[-1]
rcnt=1
for i in range(n-1,-1,-1):
    if arr[i]>front:
        front=arr[i]
        rcnt+=1
print(lcnt)
print(rcnt)