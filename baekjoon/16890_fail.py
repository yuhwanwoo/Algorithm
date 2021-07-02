import heapq


gusa=list(input())
cube=list(input())

leng=len(gusa)
cnt=leng
hq1=[]
hq2=[]

for i in gusa:
    heapq.heappush(hq1,ord(i))

for i in cube:
    heapq.heappush(hq2,-ord(i))

flag=True
st=0
end=leng-1
ans=["?"]*leng
while cnt:
    if flag:
        tmp=heapq.heappop(hq1)
        if tmp>-hq2[0]:
            ans[end]=chr(tmp)
            end-=1        
        else:
            ans[st]=chr(tmp)
            st+=1
                    
        flag=False
    else:
        tmp=-heapq.heappop(hq2)
        if tmp<hq1[0]:
            ans[end]=chr(tmp)
            end-=1

        else:
            ans[st]=chr(tmp)
            st+=1
                
        flag=True

    cnt-=1

print("".join(ans))