def minX(arr):
    minus=0
    for i in arr:
        if i<0:
            minus+=i
    print(minus)
    print(minus-(2*(minus))+1)
    answer=[]
    hap=0
    print("구분")
    for i in range(minus-(2*(minus))+1):
        hap=i
        for j in range(len(arr)):
            hap+=arr[j]
            if hap<1:
                break
            if j==len(arr)-1:
                if hap>=1:
                    answer.append(i)
    
    return answer[0]


#arr=[-5,4,-2,3,1]
arr=[-5,4,-2,3,1,-1,-6,-1,0,5]
arr=[-5,4,-2,3,1,-1,-6,-1,0,-5]
minX(arr)