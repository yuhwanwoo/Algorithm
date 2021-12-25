# 답
def max_div(small,big):
    while(big):
        small,big=big,small%big
    return small

def min_mul(small,big):
    result=(small*big)//max_div(small,big)
    return result

def solution(n, m):
    answer = []
    if n>m:
        n,m=m,n
    answer.append(max_div(n,m))
    answer.append(min_mul(n,m))
    print(answer)
    return answer

n=3
m=12
solution(n,m)