# [1차] 캐시
from collections import deque
def solution(cacheSize, cities):
    answer = 0

    q=deque()
    cnt=0
    if cacheSize>0:
        for i in range(len(cities)):
            cities[i]=cities[i].lower()
            if len(q)<cacheSize:
                if cities[i] in q:
                    q.remove(cities[i])
                    q.append(cities[i])
                    cnt+=1
                    
                else:
                    q.append(cities[i])
                    cnt+=5
                    
            else:
                if cities[i] in q:
                    q.remove(cities[i])
                    q.append(cities[i])
                    cnt+=1
                    
                else:
                    q.popleft()
                    q.append(cities[i])
                    cnt+=5
    else:
        cnt=len(cities)*5
    answer=cnt

    return answer

cacheSize=0
#cities=["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
cities=["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]
#cities=["Jeju", "Pangyo", "NewYork", "newyork"]
#cities=["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"]
print(solution(cacheSize,cities))
