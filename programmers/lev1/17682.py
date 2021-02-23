def solution1(dartResult):
    answer=0
    
    return answer


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

dartResult="1S2D*3T"
solution(dartResult)