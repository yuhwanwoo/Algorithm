# 첫 번째 시도 최대힙 이용(성공했네 ㅎㅎ)
import heapq

def solution(n, works):
    answer = 0
    h=[]
    leng=len(works)
    for i in range(leng):
        heapq.heappush(h,-works[i])

    for i in range(n):
        top=heapq.heappop(h)
        if top==0:
            return 0
        heapq.heappush(h,top+1)
        print(h)
    
    for i in h:
        answer+=i*i
    print(answer)
    return answer

works=[4,3,3]
n=4
solution(n,works)