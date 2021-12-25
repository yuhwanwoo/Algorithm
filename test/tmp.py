def solution(amountText):
    answer = True
    
    cnt = 0
    
    
    for i in range(len(amountText)-1, -1, -1):
        if amountText[i].isdigit():
            cnt += 1
        elif amountText[i] == ',':
            if cnt != 3:
                return False
            cnt = 0
        else:
            return False
    if amountText[0] == ',':
        return False
    
    temp = amountText.replace(",","")
    if int(temp) != 0:
        if amountText[0] == 0:
            return False
    else:
        if len(amountText) > 1:
            return False
    return answer