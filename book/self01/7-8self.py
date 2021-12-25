n,m=map(int,input().split())
rice_cake=list(map(int,input().split()))

rice_cake.sort()
start=0
end=max(rice_cake)

while start<=end:
    total=0
    mid=(start+end)//2
    for x in rice_cake:
        if x-mid>0:
            total+=(x-mid)
    if total<m:
        end=mid-1
    else:
        result=mid
        start=mid+1
    
print(result)