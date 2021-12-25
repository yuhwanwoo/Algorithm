def solution(N, stages):
    answer = []
    size=len(stages)
    people=[0]*(N+2)
    for i in stages:
        people[i]+=1
    temp=[]
    print(people)
    minus=0
    for i in range(1,len(people)-1):
        if size-minus<=0:
            temp.append((0,i))
            continue
        temp.append((people[i]/(size-minus),i))
        size=size-minus
        minus=people[i]
        
    print(temp)
    temp.sort(key=lambda x:(-x[0],x[1]))
    print(temp)
    for i in temp:
        answer.append(i[1])
    if len(temp)<N:
        temp+=([0]*(N-len(answer)))
    print(answer)
    return answer

N=5
stages=[2, 1, 2, 6, 2, 4, 3, 3]
N=3
stages=[2,2,2,2,2]
solution(N,stages)