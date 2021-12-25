def solution(a, b):
    answer = 0
    if a>b:
        a,b=b,a
    ran=list(range(a,b+1))
    answer=sum(ran)
    return answer

a=3
b=5
solution(a,b)