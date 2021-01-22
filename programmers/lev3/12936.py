# 첫번쨰 시도 단순하게 라이브러리로 풀기 (실패)

from itertools import permutations

def solution(n, k):
    answer = []
    num_list=list(range(n))
    for i in range(len(num_list)):
        num_list[i]+=1
    per=list(permutations(num_list,n))
    
    answer=per[k-1]
    return answer

