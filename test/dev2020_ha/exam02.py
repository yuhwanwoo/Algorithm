import datetime
from datetime import timedelta

def solution(p,n):
    answer = ""
    tim=p.split()
    time=tim[1].split(":")


    if tim[0]=="PM":
        time[0]=int(time[0])+12
    else:
        time[0]=int(time[0])
    print(time[0])
    d=datetime.datetime(2020,1,1,int(time[0]),int(time[1]),int(time[2]))
    
    d=d+timedelta(seconds=n)
    d=d.strftime('%H:%M:%S')
    answer=str(d)
    print(answer)
    return answer

p="PM 10:59:59"
n=2
#p="AM 11:59:59"

solution(p,n)