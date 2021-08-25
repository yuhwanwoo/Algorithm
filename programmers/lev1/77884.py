import math

def solution(left, right):
    answer = 0

    for number in range(left, right + 1):
        cnt = 0
        for i in range(1, math.ceil(number ** 1/2) + 1):
            if number % i == 0:
                if number // i == i:
                    cnt += 1
                else:
                    cnt += 2
                    
        if cnt % 2 == 0:
            answer += number
        else:
            answer -= number
    
    return answer

left = 13
right = 17

print(solution(left, right))
