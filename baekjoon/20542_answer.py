# 편집거리 알고리즘

def isCorrect(g,a):
    if g==a:
        return True
    elif (g == 'i' and (a == 'i' or a == 'j' or a == 'l')):
        return True
    elif (g == 'v' and (a == 'v' or a == 'w')):
        return True
    else:
        return False

def distance(guest,ans):
    dp=[[0]*(m+1) for _ in range(n+1)]
    for i in range(1,n+1):
        dp[i][0]=i
    for i in range(1,m+1):
        dp[0][i]=i
    print(dp)
    for i in range(1,len(dp)):
        for j in range(1,len(dp[0])):
            if isCorrect(guest[i-1],ans[j-1]):
                dp[i][j]=dp[i-1][j-1]
            else:
                dp[i][j]=min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))+1
            print(dp)

    return dp[n][m]


n,m=map(int,input().split())
guest=str(input())
ans=str(input())
print(distance(guest,ans))