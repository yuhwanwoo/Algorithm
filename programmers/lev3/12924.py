def solution(n):
    answer = 0
    min_num=0
    for i in range(n):
        if n<=sum(range(i+1)):
            min_num=i
            break
    print(min_num)
    for i in range(min_num,n+1):
        for j in range(n+1):
            if (i*(i+1)//2)-(j*(j+1)//2)==n:
                answer+=1
    print(answer)
    return answer

n=15
solution(n)