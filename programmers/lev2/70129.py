def solution(s):
    answer = []
    conv_cnt=0
    del_zero=0
    while s!="1":
        conv_cnt+=1
        temp=""
        for i in s:
            if i=="0":
                del_zero+=1
            else:
                temp+=i
        temp_length=len(temp)
        s=""
        while temp_length>0:
            s=str(temp_length%2)+s
            temp_length//=2
            
    answer.append(conv_cnt)
    answer.append(del_zero)
    return answer

s="110010101001"
solution(s)