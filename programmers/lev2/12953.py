def solution(arr):
    answer = 0
    mul=1
    i=2
    arr.sort()
    max_num=arr[-1]
    if len(arr)>1:
        while i<max_num+1:
            print(i)
            cnt=0
            for j in range(len(arr)):
                if arr[j]%i==0:
                    cnt+=1
            if cnt>1:
                for j in range(len(arr)):
                    if arr[j]%i==0:
                        arr[j]=arr[j]//i
                mul*=i
                i=2
            else:
                
                i+=1
            
    print(arr,mul)
    for i in arr:
        mul*=i
    answer=mul
    print("답",answer)
    return answer

arr=[3,4,9,16]
solution(arr)