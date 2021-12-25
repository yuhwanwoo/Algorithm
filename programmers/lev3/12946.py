answer=[]

def hanoi(a,b,n):
    if n==1:
        answer.append([a,b])
        return
    
    hanoi(a,6-a-b,n-1)
    answer.append([a,b])
    
    hanoi(6-a-b,b,n-1)


def solution(n):
    hanoi(1,3,n)
    return answer

n=2
solution(2)