isused01=[0]*12
isused02=[0]*23
isused03=[0]*23
cnt=0

def fun(cur,n):
    global cnt
    if cur==n:
        cnt+=1
        return
    for i in range(n):
        if isused01[i] or isused02[cur+i] or isused03[cur-i+n-1]:
            continue
        isused01[i]=1
        isused02[cur+i]=1
        isused03[cur-i+n-1]=1
        fun(cur+1,n)
        isused01[i]=0
        isused02[cur+i]=0
        isused03[cur-i+n-1]=0

def solution(n):
    answer = 0

    fun(0,n)

    print(cnt)
    return cnt

n=8
solution(n)