n=int(input())

dp=[0]*(n+1)
cardpack=[0]

cardpack+=list(map(int,input().split()))

for i in range(1,n+1):
    for j in range(0,i):
        dp[i]=max(dp[i],dp[j]+cardpack[i-j])

print(dp[n])