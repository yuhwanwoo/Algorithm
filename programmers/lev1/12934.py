import math

def solution(n):
    num=math.sqrt(n)
    if n%num==0:
        answer=(num+1)**2
    else:
        answer=-1

    return answer
n=121
solution(n)