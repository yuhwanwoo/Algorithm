def solution(A):
    arr=[0]*(len(A)+2)

    for i in A:
        arr[i]=1
    print(arr)
    for i in range(1,len(arr)):
        if arr[i]==0:
            return i
    return 0

A=[2,3,1,5]
solution(A)