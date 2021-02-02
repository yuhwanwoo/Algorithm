import math
def solution(n, stations, w):
    result = 0
    dis = []
    
    for i in range(1, len(stations)):
        dis.append((stations[i]-w-1) - (stations[i-1]+w))
    
    dis.append(stations[0]-w-1)
    dis.append(n - (stations[-1]+w))
    
    for i in dis:
        # 닿지 않는 거리가 0 이하일 경우 스킵한다
        if i <=0: continue
        # 닿지 않는 거리에 설치할 수 있는 최소개수를 더해준다.
        result += math.ceil(i / ((w*2) +1))
        
    return result

n=16
stations=[9]
w=2
solution(n,stations,w)