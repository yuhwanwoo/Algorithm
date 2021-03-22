n=int(input())

def pibo(n):
    if n==0:
        return 0
    if n==1:
        return 1
    
    return pibo(n-1)+pibo(n-2)


print(pibo(n))

