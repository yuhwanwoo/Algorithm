# 문자열 압축
def solution(s):
    answer = 0

    minn=1001
    #print(len(s))
    if len(s)>1:
        for i in range(1,len(s)//2+1):
            minn=min(minn,sol(i,s))
    elif len(s)==1:
        minn=1
    else:
        minn=0
    answer=minn

    return answer

def sol(size,stri): # ( 1, "aabbaccc" )
    cnt=1
    start=stri[:size]
    ans=""
    #print(start)
    for i in range(size,len(stri)+size,size):
        value=s[i:i+size]
        print(value)
        if start==value:
            cnt+=1
            start=value
            #print("if안")
        else:
            if cnt==1:
                ans+=start
                cnt=1
                start=value
                #print("else중 if",start)
            else:
                ans+=str(cnt)+start
                cnt=1
                start=value
                #print("else중 else")

    #print(len(ans))
    return len(ans)

#s="abcabcabcabcdededededede"
s="aabbaccc"
#s=""
print(solution(s))
