import bisect

n,k=map(int,input().split())

n=n+1

while True:
    arr=list(map(int,str(n)))
    arr.sort()
    left=bisect.bisect_left(arr,5)
    right=bisect.bisect_right(arr,5)
    if left==right:
        n+=1
        continue
    else:
        cnt=right-left
        # print(right,left,arr)
        if cnt>=k:
            break
    n+=1
print(n)