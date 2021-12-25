def solution(n, ladder):
    answer = []
    for i in range(n):
        index=i
        
        for j in range(len(ladder)):
            if index==0:
                
                if ladder[j][index]==1:
                    index+=1
                else:
                    continue
            elif index==(n-1):
                
                if ladder[j][index-1]==1:
                    index-=1
                else:
                    continue
            else:

                if ladder[j][index-1]==1:
                    index-=1
                    
                elif ladder[j][index]==1:
                    index+=1

        
        answer.append(index+1)

    return answer

n=4
ladder=[[1,0,1],[0,1,0],[0,0,1],[0,0,0],[1,0,0]]
solution(n,ladder)