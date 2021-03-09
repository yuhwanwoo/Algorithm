# 시간 초과 떴네 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ
n=int(input())

card_num=[]

card_num=(list(map(int,input().split())))


def sol(num,sum_num):
    max_num=sum_num
    if num==n:

        return sum_num
    if num>n:
        return 0
    
    for i in range(1,n+1):
        max_num=max(max_num,sol(num+i,sum_num+card_num[i-1]))


    return max_num
print(sol(0,0))

# 1

# 1 1
# 2


# 1 1 1
# 1 2
# 3

# 1 1 1 1 # 5
# 2 1 1
# 2 2
# 3 1
# 4


# 1 1 1 1 1 # 7
# 2 1 1 1
# 2 2 1
# 3 1 1
# 3 2
# 4 1
# 5

# 1 1 1 1 1 1 #11
# 2 1 1 1 1
# 2 2 1 1
# 2 2 2
# 3 1 1 1
# 3 2 1
# 3 3
# 4 1 1
# 4 2
# 5 1
# 6

# 1 1 1 1 1 1 1 # 14
# 2 1 1 1 1 1
# 2 2 1 1 1
# 2 2 2 1
# 3 1 1 1 1
# 3 2 1 1
# 3 2 2
# 3 3 1
# 4 1 1 1
# 4 2 1
# 4 3
# 5 2
# 6 1
# 7