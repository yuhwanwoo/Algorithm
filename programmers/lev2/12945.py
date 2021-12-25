def solution(n):
    answer = 0
    d=[0]*(n+1)
    d[1]=1
    for i in range(2,n+1):
        d[i]=d[i-2]+d[i-1]
    answer=d[n]%1234567
    return answer

n=3
solution(n)