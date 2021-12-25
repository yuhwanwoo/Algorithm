# 프린터

from collections import deque

def solution(priorities, location):
    answer = 0
    d = deque([(v,i) for i,v in enumerate(priorities)])
    

    while d:
        top=d.popleft()
        print("d",d)
        if d and max(d)[0]>top[0]:
            d.append(top)
        else:
            answer+=1
            if top[1]==location:
                break
    print(answer)
    return answer

#priorities=[2, 1, 3, 2]
priorities=[3,3,4,2]
#location=2
location=3
solution(priorities,location)