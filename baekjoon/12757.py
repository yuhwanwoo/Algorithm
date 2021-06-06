import sys
import bisect

input=sys.stdin.readline

n,m,k=map(int,input().split())

keys=[]
dic=dict()

def putkey(key):
    bisect.insort(keys,key)
    return

def findkey(key):
    idx=0
    val=dic.get(key,-1)
    leng=len(keys)
    if val != -1:
        return key
    else:
        key_idx=bisect.bisect(keys,key)
        if key_idx==0:
            if abs(keys[0]-key)<=k:
                return keys[0]
        elif key_idx==len(keys):
            if abs(keys[key_idx-1]-key)<=k:
                return keys[key_idx-1]
        else:
            # 답이 ?가 나와야함
            if keys[key_idx]-key==key-keys[key_idx-1]:
                return -2
            # 답 1개
            if keys[key_idx]-key>key-keys[key_idx-1]:
                if key-keys[key_idx-1]<=k:
                    return keys[key_idx-1]
            # 답 1개
            if keys[key_idx]-key<key-keys[key_idx-1]:
                if keys[key_idx]-key<=k:
                    return keys[key_idx]

    # 답이 1이 나와야함
    return -1



for i in range(n):
    key,val=map(int,input().split())
    dic[key]=val
    putkey(key)

for i in range(m):
    arr=list(map(int,input().split()))
    if arr[0]==1:
        dic[arr[1]]=arr[2]
        putkey(arr[1])
    if arr[0]==2:
        tmpkey=findkey(arr[1])
        if tmpkey==-1 or tmpkey==-2:
            continue
        else:
            dic[tmpkey]=arr[2]
    if arr[0]==3:
        tmpkey=findkey(arr[1])
        if tmpkey==-1:
            print(-1)
        elif tmpkey==-2:
            print("?")
        else:
            print(dic[tmpkey])
    
        
