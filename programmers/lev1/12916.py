def solution(s):
    answer = True
    cntp=0
    cnty=0
    for i in s:
        if i=='p' or i=='P':
            cntp+=1
        if i=='y' or i=='Y':
            cnty+=1
    
    if cntp==cnty:
        answer=True
    else:
        answer=False
    return answer

s="pPoooyY"
solution(s)