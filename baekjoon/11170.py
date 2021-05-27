n=int(input())

def flag(num):
    cnt=0
    for i in num:
        if i=="0":
            cnt+=1
    return cnt



for i in range(n):
    answer=0
    start,end=map(int,input().split())
    for i in range(start,end+1):
        answer+=flag(str(i))
    
    print(answer)