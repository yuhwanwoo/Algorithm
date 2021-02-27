def solution(A):
    num_dict=dict()

    for i in range(len(A)):
        num_dict[A[i]]=num_dict.get(A[i],0)+1

    for i in num_dict.keys():
        if num_dict[i]%2==1:
            return i

    
A=[9,3,9,3,9,7,9]
print(solution(A))