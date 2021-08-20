import heapq

def solution(jobs):
    answer = 0
    cnt = 0
    start = -1
    
    size = len(jobs)
    
    heap = []
    jobs.sort()
    time = jobs[0][0]

    while cnt < size:
        for s,t in jobs:
            if start < s <= time:
                heapq.heappush(heap, (t,s))    
        if len(heap) > 0:
            cnt += 1
            start = time
            term, sta = heapq.heappop(heap)
            time += term
            print(start, time)
            answer += (time - sta)
        else:
            time += 1
        

    return answer // size

jobs=[[0, 5], [2, 10], [100000000000, 2]]
print(solution(jobs))