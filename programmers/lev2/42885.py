# 효율성 뺴고 맞는 답
def solution(people, limit):
    answer = 0
    people.sort()
    for i in range(len(people)):
        for j in range(len(people)-1,i,-1):
            if people[i]+people[j]<=limit:
                answer+=1
                people.pop(i)
                people.pop(j-1)
                break
    answer+=len(people)
    print(answer)
    return answer
    

    

people=[70,80,60,50,40,30] # 4
people=[50,40]
limit=100
solution(people,limit)