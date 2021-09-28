def solution(enter, leave):
    answer = [0] * len(enter)
    ent_dict = dict()

    for i in enter:
        ent_dict[i] = 0
    
    for i in range(len(enter)):
        element = enter[i]
        ent_dict[element] = 1
        for j in range(i + 1, len(enter)):
            ent_dict[enter[j]] = 1
        for j in range(len(leave)):
            if element == leave[j]:
                break
            if ent_dict[leave[j]] == 1:
                answer[i] += 1
                answer[leave[j]] += 1
        for i in enter:
            ent_dict[i] = 0

    print(answer)


    return answer


enter = [1,3,2]
leave = [1,2,3]
enter = [1,4,2,3]
leave = [2,1,3,4]
solution(enter, leave)