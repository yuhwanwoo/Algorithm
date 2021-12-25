def solution(n, colors):
    answer = 0

    data=[]
    cnt=1
    for i in range(1,n):
        if colors[i-1]!=colors[i]:
            data.append((cnt,i,colors[i-1]))
            cnt=1
        else:
            cnt+=1
        if cnt!=1 and i==(n-1):
            data.append((colors[i],cnt))
        if cnt==1 and i==(n-1):
            data.append((colors[i],1))
    
    data.sort()
    print(data)
    
    return answer

n=10
colors=[1,1,2,2,2,3,3,3,2,2]
solution(n,colors)