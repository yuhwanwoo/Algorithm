def solution(a, b):
    answer = ''

    week=["FRI","SAT","SUN","MON","TUE","WED","THU"]
    mon=[31,29,31,30,31,30,31,31,30,31,30,31]

    answer=week[(sum(mon[:a-1])+b-1)%7]
    return answer

a=1
b=1
solution(a,b)