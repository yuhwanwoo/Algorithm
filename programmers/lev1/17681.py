def solution(n, arr1, arr2):
    answer = ["" for _ in range(n)]
    
    temp_arr=[]
    for i in range(n):
        temp=(bin(arr1[i]|arr2[i]))
        size=n-(len(temp)-2)
        
        temp_arr.append([0]*size+list(map(int,temp[2:])))
    
    print(temp_arr)
    for i in range(n):
        for j in range(n):
            if temp_arr[i][j]==1:
                answer[i]+="#"
            else:
                answer[i]+=" "
    print(answer)
    return answer

n=5
arr1=[9,20,28,18,11]
arr2=[30, 1, 21, 17, 28]
solution(n, arr1, arr2)