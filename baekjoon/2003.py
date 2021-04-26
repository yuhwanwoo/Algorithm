n,m=map(int,input().split())
arr=list(map(int,input().split()))

start=0
end=0
summ=0
result=0
while True:
    if summ>=m:
        summ-=arr[start]
        start+=1
    elif end==n:
        break
    else:
        summ+=arr[end]
        end+=1
    if summ==m:
        result+=1

print(result)
