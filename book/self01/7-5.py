
def binary_search(stor,target,start,end):
    while start<=end:
        mid=(start+end)//2
        if stor[mid]==target:
            return True
        elif stor[mid]>target:
            end=mid-1
        else:
            start=mid+1
    return None
        
n=int(input())
stor=list(map(int,input().split()))
stor.sort()
m=int(input())
requ=list(map(int,input().split()))

for i in requ:
    if binary_search(stor,i,0,n-1)==True:
        print("yes",end=' ')
    else:
        print("no",end=' ')
        
