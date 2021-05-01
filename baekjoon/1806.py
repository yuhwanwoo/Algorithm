n,s=map(int,input().split())
arr=list(map(int,input().split()))

st=0
end=0
value=0
answer=int(1e9)
while True:
    if value>=s:
        #answer=min(answer,end-st)
        value-=arr[st]
        st+=1
    elif end==n:
        break
    else:
        value+=arr[end]
        end+=1
    #print(st,end,value)
    if value>=s:
        # print(end,st)
        answer=min(answer,end-st)

if answer==int(1e9):
    print(0)
else:
    print(answer)