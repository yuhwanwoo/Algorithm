def solution(A,B):
    answer = 0

    A.sort()
    B.sort()

    for i in range(len(A)):
        answer+=A[i]*B[len(B)-1-i]
            
    print(answer)
    return answer

# A=[1,4,2]
# B=[5,4,4]
A=[1,2]
B=[3,4]
solution(A,B)