# 첫번쨰 시도 단순하게 라이브러리로 풀기 (실패)

from itertools import permutations
import math

# 답
def solution(n, k):
    answer = []
    numberList = [i for i in range(1, n+1)]
    print(numberList)
    while (n != 0):
        temp = math.factorial(n) // n
        index = k // temp
        k = k % temp
        print("n:",n,"_k:",k,"_temp:",temp,"_index:",index)
        print(numberList)
        if k == 0:
            answer.append(numberList.pop(index-1))
        else :
             answer.append(numberList.pop(index))

        n -= 1
    
    return answer

def solution1(n, k):
    answer = []
    num_list=list(range(n))
    for i in range(len(num_list)):
        num_list[i]+=1
    per=list(permutations(num_list,n))
    
    answer=per[k-1]
    return answer

n=3
k=5
solution(n,k)