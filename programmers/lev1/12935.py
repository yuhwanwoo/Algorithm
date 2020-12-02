def solution(arr):
    answer = []
    temp=[]
    for i in range(len(arr)):
        temp.append((arr[i],i))
    temp.sort(reverse=True)
    temp.pop()
    
    temp.sort(key=lambda x:x[1])
    
    for i in temp:
        answer.append(i[0])
    if not answer:
        answer=[-1]
    return answer

arr=[4,3,2,1]
solution(arr)