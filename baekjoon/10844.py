n=int(input())

MinNumber=0

if n%2==0:
    MinNumber="11"*(n//2)
else:
    MinNumber="7"+"11"*(n//2-1)

# 1 2 3 4 5 6 7 8 9 0
# 2 5 5 4 5 6 3 7 6 6

# 2 3 4 5 6 7 8  9  10 11 12
# 1 7 4 2 6 8 20 18 23 20 28
