import heapq

# 대기 중인 것들 중에 처리되는 속도가 가장 작은걸 우선으로 
def solution(jobs):
    count, last, answer = 0, -1, 0
    heap = []
    jobs.sort()
    # 시작시간 초기화
    time = jobs[0][0]
    while count < len(jobs):
        for s, t in jobs:
            if last < s <= time:    0 10
                # 작업 소요시간으로 min heap을 만들기 위해 (t, s) 푸시
                heapq.heappush(heap, (t, s))
        # 바로 수행할 수 있는 작업이 있는 경우
        
        if len(heap) > 0:
            count += 1 # 1
            last = time # 0
            term, start = heapq.heappop(heap) # 10,0
            time += term # time 10 = 0  + term 10
            answer += (time - start) # 10-0
        # 바로 수행할 수 있는 작업이 없는 경우
        else:
            time += 1
    return answer//len(jobs)

#jobs=[[0, 3], [1, 9], [2, 6]]
#jobs=[[0, 3], [4, 3], [10, 3]]              # 3
jobs=[[0, 10], [4, 10], [5, 11], [15, 2]]
print(solution(jobs))