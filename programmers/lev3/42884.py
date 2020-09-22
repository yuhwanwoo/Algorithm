def solution(routes):
    answer = 0
    routes.sort()
    start_time=routes[0][1]
    answer+=1
    
    for i in range(1,len(routes)):
        if routes[i][0]<=start_time:
            start_time=min(routes[i][1],start_time)
        else:
            start_time=routes[i][1]
            answer+=1
    return answer
    

routes=[[-20,15], [-14,-5], [-18,-13], [-5,-3]]
solution(routes)