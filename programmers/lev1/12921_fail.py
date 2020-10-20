# 효율성 틀림
# 에라포스테네스의 체를 이용해야 하나보다
import math

def solution(n):
    answer = 0
    sosu=[]
    if n>=2:
        for i in range(2,n+1):
            sosu.append(i)
            for j in range(2,int(math.sqrt(n)+1)):
                if i%j==0 and i!=j:
                    sosu.pop()
                    break
        answer=len(sosu)
    return answer

n=5
solution(n)