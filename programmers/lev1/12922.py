def solution(n):
    answer = ''
    wm=["수","박"]
    
    cnt=0

    while cnt<int(n):
        if cnt%2==0:
            answer+=wm[0]
        else:
            answer+=wm[1]
        cnt+=1
    
    print(answer)


    return answer

n="4"
solution(n)