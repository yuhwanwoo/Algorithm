n=int(input())

primes=[]
a=[False,False]+[True]*(n-1)

for i in range(2,n+1):
  if a[i]:
    primes.append(i)
    for j in range(2*i, n+1, i):
        a[j] = False

total=0
start=0
end=0
answer=0
length=len(primes)

while True:
    if total>=n:
        total-=primes[start]
        start+=1
    elif end==length:
        break
    else:
        total+=primes[end]
        end+=1
    if total==n:
        answer+=1
        
print(answer)