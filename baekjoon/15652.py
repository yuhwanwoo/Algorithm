n,m=map(int,input().split())

arr=[0]*10
isused=[0]*10

def fun(cur):
    if cur==m:
        for i in range(m):
            print(arr[i],end=' ')
        print()
        return
    
    for i in range(1,n+1):
        if cur>0 and arr[cur-1]>i:
            continue
        arr[cur]=i
        # isused[i]=1
        fun(cur+1)
        # isused[i]=0

fun(0)