# 이중우선순위큐
import heapq
def heap_change(heap):
    heapp = []
    for num in heap:
        heapq.heappush(heapp, -num)
    return heapp

def solution(operations):
    answer = []
    minq=[]
    maxq=[]
    for i in operations:
        a,b=i.split()
        if a=='I':
            heapq.heappush(minq,int(b))
            heapq.heappush(maxq,-int(b))
        elif a=="D":
            if int(b)>0:
                if len(maxq)==0:
                    continue
                else:
                    heapq.heappop(maxq)
                    minq=heap_change(maxq)
            else:
                if len(maxq)==0:
                    continue
                else:
                    heapq.heappop(minq)
                    maxq=heap_change(minq)
           
    if len(maxq)!=0:
        answer.append(-maxq[0])
    else:
        answer.append(0)
    if len(minq)!=0:
        answer.append(minq[0])
    else:
        answer.append(0)
    print(answer)
    return answer

operations=["I 7","I 5","I -5","D -1"]
#operations=["I 16","D 1"]
solution(operations)