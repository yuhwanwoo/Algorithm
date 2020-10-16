def solution(strings, n):
    answer = []
    temp=[]
    for i in strings:
        temp.append((i[n],i))
    temp.sort()
    for i in temp:
        answer.append(i[1])
    print(answer)
    return answer

strings=["sun","bed","car"]
n=1
solution(strings,n)