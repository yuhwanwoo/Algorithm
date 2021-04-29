n,d=map(int,input().split())

shortcut=[]

for i in range(n):
    a,b,c=map(int,input().split())
    if b<=d and (b-a)>c:
        shortcut.append((a,b,c))

shortcut.sort(key=lambda x:(x[0],-(x[1]-x[0]-x[2])))

leng=len(shortcut)

#print(shortcut)
answer=int(1e9)
for i in range(leng):
    s,e,dis=shortcut[i]
    cur=e
    tot=s+dis
    for j in range(i+1,leng):
        #print(i,j)
        ns,ne,ndis=shortcut[j]
        if cur>ns:
            continue
        #print(cur,tot,ns,ne,ndis)
        tot+=(ns-cur)
        cur=ne
        tot+=ndis
    
    tot+=(d-cur)
    #print(cur,tot)
    answer=min(answer,tot)

if n==0:
    print(d)
else:
    print(answer)

# 실패 테케 => 방법이 틀렸다!
# 5 150
# 0 50 10
# 50 100 20
# 50 90 30
# 90 150 10
# 100 150 30