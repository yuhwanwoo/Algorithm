def solution(dartResult):
    answer=0
    tempNum=""
    num=0
    arr=[]
    for i in range(len(dartResult)):
        if dartResult[i].isdigit():
            tempNum+=dartResult[i]
        if dartResult[i].isalpha():
            num=int(tempNum)
            tempNum=""
            if dartResult[i]=="S":
                num=num
            if dartResult[i]=="D":
                num=(num*num)
            if dartResult[i]=="T":
                num=(num*num*num)
            arr.append(num)
        if dartResult[i]=="*":
            if len(arr)>=2:
                arr[-1]=(arr[-1]*2)
                arr[-2]=(arr[-2]*2)
            else:
                arr[-1]=(arr[-1]*2)
        if dartResult[i]=="#":
            arr[-1]=(-arr[-1])
    
    return sum(arr)


dartResult="1S2D*3T"
dartResult="1S*2T*3S"

solution(dartResult)

# 바로 전만 2배 하는거라 틀림
def solution1(dartResult):
    answer = 0
    tempNum=""
    Num=0
    for i in range(len(dartResult)):
        if dartResult[i]=="*":
            print(Num,"num")
            answer+=Num
            answer*=2
            Num=0
        if dartResult[i]=="#":
            answer-=Num
            Num=0
        if dartResult[i].isdigit():
            answer+=Num
            Num=0
            tempNum+=dartResult[i]
        if dartResult[i].isalpha():
            Num=int(tempNum)
            tempNum=""
            if dartResult[i]=="S":
                Num=Num
            if dartResult[i]=="D":
                Num=(Num*Num)
            if dartResult[i]=="T":
                Num=(Num*Num*Num)
            if i==len(dartResult)-1:
                answer+=Num
        print(answer,"??")
    print(answer)
    return answer