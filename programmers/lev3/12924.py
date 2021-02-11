import math

# 효율성 실패
def solution1(n):
    answer = 0
    
    num=math.ceil(n/2)
    
    for i in range(1,num+2):
        for j in range(i+1):
            
            if (i*(i+1)//2)-(j*(j+1)//2)==n:
                answer+=1
                break
    answer+=1
    print(answer)
    return answer

def solution(n):
    answer = 1
    for i in range(1, int(n/2) + 1):
        s = 0
        while s < n :
            s += i
            i += 1
        if s == n :
            answer += 1

    return answer

n=5000
solution(n)