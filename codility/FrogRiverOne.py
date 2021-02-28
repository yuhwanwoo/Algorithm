def solution(X, A):
    answer=[0]*(X+1)

    cnt=0

    for i in range(len(A)):
        
        if answer[A[i]]==0:
            answer[A[i]]+=1
            cnt+=1
        
        if cnt==X:
            return i
    return -1


X=5
A=[1,3,1,4,2,3,5,4]
print(solution(X, A))