def solution(arr):
    answer = []
    answer.append(arr[0])
    for i in range(1,len(arr)):
        if arr[i-1]!=arr[i]:
            answer.append(arr[i])
        
    return answer

arr=[1,1,3,3,0,1,1]
solution(arr)