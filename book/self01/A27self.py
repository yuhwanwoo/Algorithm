m,n=map(int,input().split())
num=list(map(int,input().split()))

cnt=0

def count_by_value(array,x):
    n=len(array)

    a=first(array,x,0,n-1)

    if a==None:
        return 0
    b=last(array,x,0,n-1)

    return b-a+1

def first(array,target,start,end):
    if start>end:
        return None
    mid=(start+end)//2
    if (mid==0 or target>array[mid-1])