n=int(input())

MinNumber=0

dp=[int(1e20)]*101

# 1 2 3 4 5 6 7 8 9 0
# 2 5 5 4 5 6 3 7 6 6

# 2 3 4 5 6 7 8  9  10 11 12
# 1 7 4 2 6 8 20 18 23 20 28

dp[2]=1
dp[3]=7
dp[4]=4
dp[5]=2
dp[6]=6
dp[7]=8
dp[8]=10

add=["1", "7", "4", "2", "0", "8"]

for i in range(9,101):
    for j in range(2,8):
        cur=str(dp[i-j])+add[j-2]
        dp[i]=min(dp[i],int(cur))

for i in range(n):
    m=int(input())
    if m%2==0:
        MinNumber="1"*(m//2)
    else:
        MinNumber="7"+"1"*(m//2-1)
    
    print(dp[m],MinNumber)

