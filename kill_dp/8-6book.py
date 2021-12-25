n=int(input())
array=list(map(int,input().split()))
d=[0]*(n+1)


d[0]=array[0]
d[1]=max(array[0],array[1])
for i in range(2,n):
    print(d,array)
    d[i]=max(d[i-1],d[i-2]+array[i])

print(d)
print(d[n-1])