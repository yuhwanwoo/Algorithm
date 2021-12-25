def solution(numbers):
    answer = []

    answer=set(answer)
    for i in range(len(numbers)-1):
        for j in range(1,len(numbers)):
            if i!=j:
                answer.add(numbers[i]+numbers[j])

    answer=list(answer)
    return answer

numbers=[2,1,3,4,1]
solution(numbers)