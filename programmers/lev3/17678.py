def mkminute(hour):
    minu=0
    h,m=hour.split(":")
    minu=int(h)*60+int(m)
    return minu

def mktime(hour):
    h=hour//60
    m=hour%60
    if h<10:
        h="0"+str(h)
    else:
        h=str(h)
    if m<10:
        m="0"+str(m)
    else:
        m=str(m)
    return h+":"+m

def solution(n, t, m, timetable):
    answer = ''
    time_dict=dict()
    timetable.sort(key=lambda x:(int(x[:2]),int(x[3:])))
    for i in range(n):
        time=540+i*t
        time_dict[time]=[]
    for key in time_dict.keys():
        cnt=0

        for i in range(m):
            if cnt==m or not timetable:
                time_dict[key]+=["x"]*(m-cnt)
                break
            else:
                print(timetable)
                print(timetable[0],"??")
                top=mkminute(timetable[0])
                if top<=key:
                    time_dict[key].append(top)
                    timetable.pop(0)
                    cnt+=1
                else:
                    time_dict[key].append("x")
                    cnt+=1

    #print(time_dict[list(time_dict.keys())[-1]][m-1])
    print(time_dict)
    if time_dict[list(time_dict.keys())[-1]][m-1]=="x":
        answer=mktime(list(time_dict.keys())[-1])
    else:
        answer=mktime(time_dict[list(time_dict.keys())[-1]][m-1]-1)
        
    print(answer)
    return answer

# n=2
# t=10
# m=2
# timetable=["09:10", "09:09", "08:00"]

# n=10
# t=60
# m=45
# timetable=["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]

n=1
t=1
m=5
timetable=["08:00","08:01","08:02","08:03"]
solution(n,t,m,timetable)