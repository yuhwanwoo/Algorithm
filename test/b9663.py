n=int(input())

arr=[0]*15
isused1=[0]*(n)
isused2=[0]*(n*2-1)
isused3=[0]*(n*2-1)
cnt=0

def fun(k):
    global cnt
    if k==n:
        cnt+=1
        return

    for i in range(n):
        if (isused1[i] or isused2[k+i] or isused3[k-i+n-1]):
            continue
        isused1[i]=1
        isused2[k+i]=1
        isused3[k-i+n-1]=1
        fun(k+1)
        isused1[i]=0
        isused2[k+i]=0
        isused3[k-i+n-1]=0

fun(0)
print(cnt)