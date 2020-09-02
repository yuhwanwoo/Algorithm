n,m,k=map(int,input().split())
data=list(map(int,input().split()))

data.sort()
first=data[n-1]
second=data[n-2]

count=int(m/(k+1))*k
count+=m%(k+1)

result=0
result+=count*first
result+=(m-count)*second

print(result)

""" a,b,c=map(int,input().split())
data=list(map(int,input().split()))

data.sort()
first=data[a-1]
second=data[a-2]

count=0

while True:
    for i in range(c):
        count+=first
        b-=1
        if(b==0):
            break
    count+=second
    b-=1
    if(b==0) :
        break

print(count) """