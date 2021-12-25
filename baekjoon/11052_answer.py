# https://mhko411.tistory.com/64

n=int(input())

dp=[0]*1001

cardpack=[0]

cardpack += (list(map(int,input().split())))+[0]*1001

for i in range(1,n+1):
    for j in range(0,i):
        dp[i]=max(dp[i],dp[j]+cardpack[i-j])

print(dp[n])