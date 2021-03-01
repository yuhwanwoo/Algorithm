# 시간 초과
def solution1(N, A):
    answer=[0]*N
    max_num=0
    for i in A:
        if i==(N+1):
            answer=[max_num]*N
            continue
        
        answer[i-1]+=1
        if max_num<=answer[i-1]:
            max_num=answer[i-1]
        
    
    return answer

def solution(N, A):
    answer=[0]*N
    max_num=0
    for i in A:
        if i==(N+1):
            answer=[max_num]*N
            continue
        
        answer[i-1]+=1
        if max_num<=answer[i-1]:
            max_num=answer[i-1]
        
    
    return answer

N=5
A=[3,4,4,6,1,4,4]
solution(N,A)