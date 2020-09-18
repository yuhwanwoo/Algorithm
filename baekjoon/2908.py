m,n=map(str,input().split())

m=m[::-1]
n=n[::-1]

if int(m)>int(n):
    print(m)
else:
    print(n)