def solution(A):
    max_num=0
    answer=0
    for i in range(len(A)):
        if max_num<abs(A[i]):
            max_num=abs(A[i])

    arr=[0]*(max_num*2+1)

    for i in range(len(A)):
        if A[i]>0:
            arr[A[i]]=1
        elif A[i]<0:
            arr[abs(A[i])+max_num]=1
        print(arr)
    
    for i in range(max_num):
        if arr[i]==arr[i+max_num]==1:
            answer=i
    return answer

A=[3,2,-2,5,-3]
A=[1,1,2,-1,2,-1]
A=[1,2,3,-4]
print(solution(A))