def solution(A):
    lis=list(range(len(A)))
    for i in range(len(lis)):
        lis[i]+=1
    print(lis)
    A.sort()
    cnt=0
    for i in range(len(A)):
        if A[i]!=lis[i]:
            cnt+=abs(A[i]-lis[i])
    return cnt

A=[1,2,1]
A=[6,2,3,5,6,3]
A=[2,1,4,4]
solution(A)