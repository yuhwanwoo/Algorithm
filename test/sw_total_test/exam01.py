def balancedSum(arr):
    pivot=0
    for i in range(len(arr)):
        if sum(arr[:i])==sum(arr[i+1:]):
            pivot=i
            break
    hap=0
    
    for i in range(len(arr)):
        hap+=arr[i]
        hap2=0
        for j in range(i+2,len(arr)):
            hap2+=arr[j]
        if hap==hap2:
            pivot=i+1
    
    return pivot
    
arr=[1,2,1]
arr=[]
balancedSum(arr)