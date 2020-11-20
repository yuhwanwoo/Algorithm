from itertools import permutations

def is_prime_not_bad(n: int) -> bool:
    if n < 2: 
        return False 
    if n == 2:
        return True 
    if n % 2 == 0: 
        return False
    l = round(n ** 0.5) + 1
    for i in range(3, l, 2):
        if n % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    ans_set=[]
    for i in range(0,len(numbers)):
        ans_set+=list(map(''.join,(permutations(numbers,i+1))))
    
    ans_set=set(list(map(int,ans_set)))
    for i in ans_set:
        if is_prime_not_bad(i):
            answer+=1
    return answer

numbers="17"
solution(numbers)