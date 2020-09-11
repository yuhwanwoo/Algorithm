# 가장 긴 팰린드롬
def solution(s):
    answer = 0


  
    maxi=1
    
    if len(s)>1:
        for i in range(len(s)):
            hap=s[i]
            for j in range(i+1,len(s)):
                hap=hap+s[j]
                reverse=hap[::-1]
                if hap==reverse:
                    maxi=max(maxi,len(hap))
            
                
    else:
        maxi=len(s)
    answer=maxi

    return answer

s=""
solution(s)