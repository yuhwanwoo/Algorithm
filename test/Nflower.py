def solution(flowers):
    answer = 0
    flowers.sort()
    start_time=flowers[0][0]
    fin_time=flowers[0][1]
    answer=fin_time-start_time
    for i in range(1,len(flowers)):
        if flowers[i][0]<=fin_time:
            start_time=fin_time
            fin_time=flowers[i][1]    
        else:
            start_time=flowers[i][0]
            fin_time=flowers[i][1]
        answer+=(fin_time-start_time)
    print(answer)
    
    return answer