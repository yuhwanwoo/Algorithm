# 다른 풀이는 그냥 프로그래머스에 풀었음
def solution(n):
    answer = 0
    a=[0]*(n+2)
    a[0]=1
    a[1]=2
    for i in range(2,n+2):
        a[i]=a[i-1]+a[i-2]
    print(a)
    return a[n-1]

n=7
print(solution(n))