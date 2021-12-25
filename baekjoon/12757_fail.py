import sys

input=sys.stdin.readline

n,m,k=map(int,input().split())

dic=dict()

for i in range(n):
    key,val=map(int,input().split())
    dic[key]=val

for i in range(m):
    arr=list(map(int,input().split()))
    if arr[0]==1:
        dic[arr[1]]=arr[2]
    if arr[0]==2:
        top=dic.get(arr[1],-2)
        if top!=-2:
            dic[arr[1]]=arr[2]
        else:
            plus=[-2]*k
            minus=[-2]*k
            cnt=0
            tmp=-1
            idx=0
            flag=False
            for i in range(k):
                data=dic.get(arr[1]+i+1,-2)
                if data!=-2:
                    plus[i]=data
                    cnt+=1
                    tmp=data
                    idx=arr[1]+i+1
                data=dic.get(arr[1]-i-1,-2)
                if data!=-2:
                    cnt+=1
                    minus[i]=data
                    tmp=data
                    idx=arr[1]-i-1
                if cnt>1:
                    flag=True
                    break
                if cnt==1:
                    flag=True
                    dic[idx]=arr[2]
                    break
            if not flag:
                continue
    if arr[0]==3:
        top=dic.get(arr[1],-2)
        if top!=-2:
            print(dic[arr[1]])
        else:
            plus=[-2]*k
            minus=[-2]*k
            cnt=0
            tmp=-1
            flag=False
            for i in range(k):
                data=dic.get(arr[1]+i+1,-2)
                if data!=-2:
                    plus[i]=data
                    cnt+=1
                    tmp=data
                data=dic.get(arr[1]-i-1,-2)
                if data!=-2:
                    cnt+=1
                    minus[i]=data
                    tmp=data
                if cnt>1:
                    flag=True
                    print("?")
                    break
                if cnt==1:
                    flag=True
                    print(tmp)
                    break
            if not flag:
                print(-1)
                continue
    # print(dic)