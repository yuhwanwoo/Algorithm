def solution(x):
    answer = True
    sum_num=0
    str_x=str(x)
    for i in str_x:
        sum_num+=int(i)
    if x%sum_num!=0:
        answer=False
    return answer

x=10
solution(x)