def solution(n):
    answer = []
    answer=list(map(int,str(n)))
    answer.reverse()
    return answer

n=12345
print(solution(n))
