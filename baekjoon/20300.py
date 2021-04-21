n=int(input())
mus_loss=list(map(int,input().split()))

mus_loss.sort()
if n%2==0:
    i=0
    j=n-1
    hap=0
    while i<j:
        hap=max(hap,mus_loss[i]+mus_loss[j])
        i+=1
        j-=1
    print(hap)

if n%2==1:
    i=0
    j=n-2
    hap=mus_loss[n-1]
    while i<j:
        hap=max(hap,mus_loss[i]+mus_loss[j])
        i+=1
        j-=1
    print(hap)
