n=int(input())

cards=[0]
cards+=list(map(int,input().split()))
cards+=[0]*1000

dp=[0]*1001

for i in range(1,n+1):
    for j in range(0,i):
        dp[i]=max(dp[i],dp[j]+cards[i-j])

print(dp[n])