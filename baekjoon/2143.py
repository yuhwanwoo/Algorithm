t=int(input())
n=int(input())
a=list(map(int,input().split()))
m=int(input())
b=list(map(int,input().split()))

lenA=len(a)
lenB=len(b)

for i in range(lenA):
    add=a[i]
    for j in range(i+1,lenA):
        add+=(a[j])
        a.append(add)

for i in range(lenB):
    add=b[i]
    for j in range(i+1,lenB):
        add+=(b[j])
        b.append(add)


a.sort()
b.sort(reverse=True)

indexA=0
indexB=0
answer=0
lenA=len(a)
lenB=len(b)

while (indexA<lenA and indexB<lenB):
    if (a[indexA]+b[indexB])==t:
        cntA=0
        cntB=0
        subsumA=a[indexA]
        subsumB=b[indexB]
        while indexA<lenA:
            if subsumA == a[indexA]:
                cntA+=1
                indexA+=1 
            else:
                break
        while indexB<lenB:
            if subsumB == b[indexB]:
                
                cntB+=1
                indexB+=1
            else:
                break
        answer+=(cntA*cntB)
    elif (a[indexA]+b[indexB])<t:
        indexA+=1
    else:
        indexB+=1
print(answer)