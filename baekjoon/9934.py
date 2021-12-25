k=int(input())

arr=list(map(int,input().split()))
ans=[[] for _ in range(k)]
#str(arr[m])+" "
def solve(s,e,deep):
    if deep==k:
        return

    m=(s+e)//2
    ans[deep].append(str(arr[m]))

    solve(s,m-1,deep+1)
    solve(m+1,e,deep+1)

solve(0,len(arr),0)

for i in range(len(ans)):
    for j in range(len(ans[i])):
        print(ans[i][j],end=" ")
    print()