def solution(S):
    dic=dict()
    for i in range(len(S)):
        for j in range(len(S[i])):
            dic[j]=dic.get(j,[])+[(S[i][j],i)]
    
    for i in range(len(dic)):
        dic[i].sort()
    answer=[]
    print(dic)
    if len(dic)>0:
        for i in range(0,len(dic)):
            for j in range(1,len(dic[i])):
                if dic[i][j][0]==dic[i][j-1][0]:
                    answer=[dic[i][j-1][1],dic[i][j][1],i]
    
    return answer


S=["abc","bca","dbe"]
#S=['zzzz', 'ferz', 'zdsr', 'fgtd']
#S=['gr', 'sd', 'rg']
print(solution(S))