# 조이스틱
# ABBBBBBBBBBAAAABB 이 경우 확인해야해
def solution(name):
    answer = 0
    index=[]

    for i in range(len(name)):
        num=ord(name[i])-ord('A')
        if num<=13:
            answer+=num
        else:
            answer+=(26-num)
        if i!=0 and name[i]!='A':
            index.append(i)

    if index:
        ans = min(index[-1], len(name) - index[0]) 
        for i in range(len(index)-1):            
            if len(index)>1:
                ans=min(ans,index[i]+index[i]+len(name)-index[i+1])
                ans=min(ans,(len(name)-index[i+1])*2+index[i])
                print(len(name)-index[i+1])
            else:
                continue
    else:
        ans=0

    answer+=ans
    return answer

name="ABBBBBBBBBBAAAABB"  #17개 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 16]

print(solution(name))