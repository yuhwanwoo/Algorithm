# 균형잡힌 문자열 인덱스
def balanced_string(p):
    count=0

    for i in range(len(p)):
        if p[i]=='(':
            count+=1
        else:
            count-=1
        
        if count==0:
            return i

# 올바른 괄호 물자열인지 판단
def check_proper(p):
    count=0
    for i in p:
        if i=='(':
            count+=1
        else:
            if count==0:
                return False
            count-=1
    return True


def solution(p):
    answer = ''
    if p=='':
        return answer
    return answer