def equal_s(s):
    stack=[]
    cnt=0
    if len(s)==1:
        return False
    for i in range(len(s)):
        if s[i]=='(':
            cnt+=1
            stack.append(s[i])
        elif s[i]=='{':
            cnt+=1
            stack.append(s[i])
        elif s[i]=='[':
            cnt+=1
            stack.append(s[i])
        elif s[i]==')':
            cnt-=1
            if not stack:
                return False
            temp=stack.pop()
            if temp=='(':
                continue
            else:
                return False
        elif s[i]=='}':
            cnt-=1
            if not stack:
                return False
            temp=stack.pop()
            if temp=='{':
                continue
            else:
                return False
        else:
            cnt-=1
            if not stack:
                return False
            temp=stack.pop()
            if temp=='[':
                continue
            else:
                return False
    if cnt!=0:
        return False
    return True

def solution(s):
    answer = 0
    n=len(s)
    for i in range(n):
        s=s[1:]+s[0]
        if equal_s(s):
            print(s)
            answer+=1

    return answer

s='[](){}'
s="}}}"
s="}]()[{"
s="([{)}]"
s="}}}}}}}"
s="("
s=")"
s="){("
print(solution(s))