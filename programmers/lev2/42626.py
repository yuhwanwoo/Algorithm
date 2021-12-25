import heapq

def solution(scoville, K):
    answer = 0
    h=[]
    val=[]
    for value in scoville:
        heapq.heappush(h,value)
    temp=0
    hap=0
    while h:
        temp=heapq.heappop(h)
        print(temp,"temp")
        if (temp>=K) & (len(val)==0):
            return answer

        val.append(temp)
        if len(val)==2:
            val.sort()
            print(val)
            answer+=1
            hap=val[0]+(val[1]*2)
            heapq.heappush(h,hap)
            print(h)
            val=[]

    return -1

# scoville=[1,2,3,9,10,12]
# K=7
scoville=[2,3,4,6]
K=5
print(solution(scoville,K))