from collections import deque

def solution(jobs):
    answer = []

    tmp_arr = []
    impor_dict = dict()
    for job in jobs:
        impor_dict[job[2]] = 0
    
    q = deque(jobs)

    time = jobs[0][0]
    number = jobs[0][2]
    
    
    answer.append(number)
    while q:
        top = q[0][0]
        print("time: ",time)
        if time >= top:
            tmp  = q.popleft()
            tmp_arr.append(tmp)
            impor_dict[tmp[2]] += tmp[3] 
            continue

        print(impor_dict)
        print(tmp_arr, number)
        tmp_arr.sort(key = lambda x:(abs(x[2]-number), -impor_dict[x[2]], x[2]))
        print(tmp_arr)
        
        if tmp_arr:
            s, t, num, w = tmp_arr.pop(0)
            if number != num:
                answer.append(num)
                number = num
            time += t
            impor_dict[num] -= w
            continue
        noww = q.popleft()
        tmp_arr.append(noww)
        

    tmp_arr.sort(key = lambda x:(abs(x[2]-number), -impor_dict[x[2]], x[2]))
    
    while tmp_arr:
        s, t, n, w = tmp_arr.pop(0)
        if number != n:
            answer.append(n)
            number = n

    return answer