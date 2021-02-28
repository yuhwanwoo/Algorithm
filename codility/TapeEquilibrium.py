def solution(A):
    first_part=0
    sum_A=sum(A)
    
    length=len(A)
    num=int(1e9)
    if length>1:
        for i in range(1,len(A)):
            first_part+=A[i-1]
            sum_A-=A[i-1]
            
            num=min(num,abs(first_part-sum_A))
        
    else:
        return A[0]
    return num
    


A=[3,1,2,4,3]
A=[-1000,1000]
A=[1,1]
print(solution(A))