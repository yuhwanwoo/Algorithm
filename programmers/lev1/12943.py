def solution(num):
    answer = 0
    cnt=0
    if num!=1:
        while cnt<500:
            if num%2==0:
                num//=2
                cnt+=1
                if num==1:
                    break
            else:
                num=(num*3)+1
                cnt+=1
                if num==1:
                    break
    else:
        return 0
    if cnt==500:
        answer=-1
    else:
        answer=cnt
    return answer