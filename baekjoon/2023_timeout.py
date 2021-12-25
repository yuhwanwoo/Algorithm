m=int(input())

a = [False,False] + [True]*(10**m-1)
primes=[]

for i in range(2,10**m//2):
    # if a[i]:
    #     primes.append(i)
    for j in range(2*i, 10**m, i):
        a[j] = False

def judge(num):
    while len(num):
        num=int(num)
        if not a[num]:
            return False
        num=str(num)
        num=num[:-1]
    return True


def sol(num):
    for i in range(num,num*10):
        if judge(str(i)):
            print(i)

    return

sol(10**(m-1))