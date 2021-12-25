def solution(answers):
    answer = []

    su=[
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]

    supo=[0,0,0]

    for i in range(len(answers)):
        if answers[i]==su[0][i%5] : supo[0]+=1
        if answers[i]==su[1][i%8] : supo[1]+=1
        if answers[i]==su[2][i%10] : supo[2]+=1

    for i in range(len(supo)):
        if max(supo)==supo[i]:
            answer.append(i+1)

    answer.sort()
    
    return answer

answers=[1,3,2,4,2]

print(solution(answers))