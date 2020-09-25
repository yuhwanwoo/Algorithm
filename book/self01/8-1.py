# 피보나치 이걸로하면 큰일난다
def fibo(x):
    if x==1 or x==2:
        return 1
    else:
        return fibo(x-1)+fibo(x-2)

print(fibo(4))