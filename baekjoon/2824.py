# 유클리드 호제법
import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())

a = list(map(int, input().split()))

mulA = 1

for i in a:
    mulA *= i

m = int(input())
b = list(map(int, input().split()))

mulB = 1

for i in b:
    mulB *= i

def gcd(x, y):

    if y == 0:
        return x
    
    return gcd(y, x%y)

if mulA > mulB:
    print(str(gcd(mulA, mulB))[-9:])
else:
    print(str(gcd(mulB, mulA))[-9:])