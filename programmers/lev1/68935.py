def solution(n):
    answer = 0
    n_gin=[]
    if n>=3:
        while n>=3:
            n_gin.append(n%3)
            n//=3
            if n<3:
                n_gin.append(n)
    else:
        n_gin.append(n)
    for i in range(len(n_gin),0,-1):
        answer+=n_gin[i-1]*(3**(len(n_gin)-i))
    
    return answer

n=45
n=2
n=0
n=5
print(solution(n))