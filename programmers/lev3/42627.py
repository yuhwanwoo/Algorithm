# 디스크 컨트롤러
import heapq

def solution(jobs):
    answer = 0
    cnt=0
    start=-1

    heap=[]
    jobs.sort()
    time=jobs[0][0]

    while cnt<len(jobs):
        for s,t in jobs:
            if start<s<=time:
                heapq.heappush(heap,(t,s))    
        if len(heap)>0:
            cnt+=1
            start=time
            term,sta=heapq.heappop(heap)
            time+=term
            answer+=(time-sta)
        else:
            time+=1
    return answer//len(jobs)



#jobs=[[0, 3], [1, 9], [2, 6]]
jobs=[[0, 10], [4, 10], [5, 11], [15, 2]]
solution(jobs)