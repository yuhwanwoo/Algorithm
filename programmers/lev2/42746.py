def solution(numbers):
    answer = ''
    strings=list(map(str,numbers))
    strings.sort(key=lambda x:x*3,reverse=True)
    print(strings)
    answer=''.join(strings)
    answer=int(answer)
    answer=str(answer)
    return answer

numbers=[6, 10, 2]
numbers=[3, 30, 34, 5, 9]
numbers=[0,0,0,0,0]
print(solution(numbers))