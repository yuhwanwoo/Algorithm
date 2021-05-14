# 이 풀이 아직 실패인데 해결하고 스택으로 풀자

def equal_s(s):
    big=0
    mid=0
    small=0
    for i in range(len(s)):
        if s[i]=='(':
            big+=1
        elif s[i]==')':
            big-=1
        elif s[i]=='[':
            mid+=1
        elif s[i]==']':
            mid-=1
        elif s[i]=='{':
            small+=1
        elif s[i]=='}':
            small-=1
        else:
            continue
        if small<0 or mid<0 or big<0:
            return False
    if small==0 and mid==0 and big==0:
        return True
    return False

def solution(s):
    answer = 0
    n=len(s)
    for i in range(n):
        s=s[1:]+s[0]
        if equal_s(s):
            answer+=1

    return answer

s='[](){}'
s="}}}"
s="{{{{{{{"
s="([{)}]"
print(solution(s))