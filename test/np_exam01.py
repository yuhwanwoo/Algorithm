def solution(S):
    answer=[]

    dic=dict()
    leng=len(S[0])

    for i in range(len(S)):
        for j in range(leng):
            
            dic[S[i][j]]=dic.get(S[i][j],[])+[(j,i)]
    for i in dic.keys():
        dic[i].sort()

        for j in range(1,len(dic[i])):
            if dic[i][j][0]==dic[i][j-1][0]:
                answer=[dic[i][j-1][1],dic[i][j][1],dic[i][j][0]]

    return answer
    


S=["abc","bca","dbe"]
S=["gr","sd","rg"]
S=["zzzz","ferz","zdsr","fgtd"]
print(solution(S))