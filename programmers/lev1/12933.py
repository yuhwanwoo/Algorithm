def solution(n):
    answer = 0
    temp=list(str(n))
    temp.sort(reverse=True)
    answer=int("".join(temp))
    return answer

n=118372
solution(n)