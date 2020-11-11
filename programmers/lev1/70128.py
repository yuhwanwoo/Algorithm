def solution(a, b):
    answer = 0
    n=len(a)
    for i in range(n):
        answer+=(a[i]*b[i])
    return answer
a=[1,2,3,4]
b=[-3,-1,0,2]
solution(a,b)