def solution(A):
    arr=[0]*100001
    for i in A:
        if i<=0:
            continue
        arr[i]+=1

    for i in range(1,len(arr)):
        if arr[i]==0:
            return i

A=[1,3,6,4,1,2]
solution(A)