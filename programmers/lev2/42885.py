# 효율성 뺴고 맞는 답
def solution1(people, limit):
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

# 히히 맞췄지롱
def solution(people,limit):
    answer=0
    people.sort()
    first_index=0
    last_index=len(people)-1
    if len(people)==1:
        return 1
    
    while True:
        if first_index>last_index:
            break
        if first_index==last_index:
            answer+=1
            break
        if people[first_index]+people[last_index]<=limit:
            answer+=1
            first_index+=1
            last_index-=1
        else:
            answer+=1
            last_index-=1
    return answer

    

people=[70,80,60,50,40,30] # 4
# 30 40 50 60 70 80
people=[50,40]
limit=100
solution(people,limit)