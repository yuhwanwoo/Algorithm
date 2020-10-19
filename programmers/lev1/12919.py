def solution(seoul):
    answer = ''
    num=0
    for i in range(len(seoul)):
        if seoul[i] =="Kim":
            num=i
            break
    answer="김서방은 "+str(i)+"에 있다"
    return answer

seoul=["Jane","Kim"]
solution(seoul)