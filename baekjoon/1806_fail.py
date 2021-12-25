n,s=map(int,input().split())
arr=list(map(int,input().split()))

st=0
end=0
value=arr[0]
answer=int(1e9)
while True:
    if st>n-1:
        break
    if value==s:
        answer=min(answer,end-st+1)
        end+=1
        if end==n:
            end-=1
            st+=1
            continue
        value+=arr[end]
    elif value>s:
        value-=arr[st]
        st+=1
    elif value<s:
        end+=1
        if end==n:
            end-=1
            st+=1
            continue
        value+=arr[end]

if answer==int(1e9):
    print(-1)
else:
    print(answer)