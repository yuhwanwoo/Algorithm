from itertools import permutations

def isPrime(n):
    if n < 2: 
        return False 
    if n == 2:
        return True 
    if n % 2 == 0: 
        return False
    for i in range(3, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    ans=[]
    for i in range(len(numbers)):
        ans+=list((map(int,map(''.join,(permutations(numbers,i+1))))))
    ans=set(ans)
    for i in ans:
        if isPrime(i):
            answer+=1
    return answer

numbers="011"
solution(numbers)