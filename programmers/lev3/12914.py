def solution(n):
    answer = 0
    answer=[0]*2001
    answer[0]=1
    answer[1]=2
    for i in range(2,n+2):
        answer[i]=answer[i-1]+answer[i-2]
    print(answer[:n])
    ans=answer[n-1]%1234567
    return ans

n=5
print(solution(n))