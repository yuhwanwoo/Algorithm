def solution(d, budget):
    answer = 0
    sum_money=0
    d.sort()
    for money in d:
        sum_money+=money
        answer+=1
        if sum_money>budget:
            answer-=1
            break
    return answer

d=[1,3,2,5,4]
budget=9
solution(d,budget)