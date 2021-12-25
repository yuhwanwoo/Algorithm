n,m=map(int,input().split())

arr=[0]*10
isused=[0]*10

def func(k):
    if k == m:
        for i in range(m):
            print(arr[i],end=' ')
        print()
        return
    
    for i in range(1,n+1):
        if not isused[i]:
            arr[k]=i
            isused[i]=1
            func(k+1)
            isused[i]=0


func(0)    