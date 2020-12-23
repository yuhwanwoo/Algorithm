def solution(arr):
    answer = 0
    mul=1
    arr.sort()
    for i in range(arr[0],arr[-1]):
        cnt=0
        for j in range(len(arr)):
            if arr[j]%i==0:
                arr[j]=arr[j]//i
                cnt+=1
        if cnt>0:
            mul*=i
    
    for i in arr:
        mul*=i
    answer=mul
    return answer

arr=[1,2,7]
solution(arr)