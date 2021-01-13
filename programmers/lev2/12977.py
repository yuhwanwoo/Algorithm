# 그냥 눈에 보이는대로 첫번째 시도
from itertools import combinations
import math

def solution(nums):
    answer = 0


    test_data=list(map(sum,list(combinations(nums,3))))
    print(test_data)
    for sum_data in test_data:
        sqrt=int(math.sqrt(sum_data))
        for n in range(2,sqrt+1):
            if sum_data%n==0:
                break
            if n==sqrt and sum_data%n!=0:
                answer+=1
    print(answer)
    return answer

nums=[1,2,7,6,4]
solution(nums)