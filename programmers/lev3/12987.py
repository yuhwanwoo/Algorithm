import heapq

def solution(A,B):
    answer=0
    A.sort(reverse=True)

    
    

    return answer


# 1차 시도 실패(접근은 좋았는데 효율성 될줄알았는데 안되네 ㅎㅎ)
def solution1(A, B):
    answer = 0
    A.sort(reverse=True)
    B.sort()
    
    print(A)
    print(B)
    a_index=0
    b_index=0
    while True:
        size=len(B)
        asize=len(A)
        if b_index>=size:
            b_index=0
            a_index+=1
            continue
        if a_index>=asize:
            break
        if B[b_index]<=A[a_index]:
            print(A,B)
            print(a_index,b_index)
            b_index+=1
            
            continue
        else:
            B.pop(b_index)#[7] [2]
            A.pop(a_index)
            answer+=1
            b_index=0
            a_index=0
    print(A,B)
    print(answer)
        
    return answer

A=[5,1,3,7]
B=[2,2,6,8]
solution(A,B)