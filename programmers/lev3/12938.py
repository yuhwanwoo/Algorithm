import math

def solution(n, s):
    answer = []
    m=n
    init=s
    sum_num=0
    for i in range(n):
        if i==n-1:
            answer.append(init-sum_num)
            break
        temp=s/(n-i)
        temp=math.ceil(temp)
        sum_num+=temp
        
        answer.append(temp)
        if temp==0:
            return [-1]
        s-=temp
        if s==0:
            return [-1]

    answer.sort()
    
    # 10
    # (1,1,7),(1,2,6),(1,3,6)(1,4,5)(2,2,6)(2,3,5)(2,4,4)(3,3,4)
    return answer

n=4
s=11
print(solution(n,s))