def solution(array, commands):
    answer = []
    for command in commands:
        a,b,c=command
        arr=array[a-1:b]
        arr.sort()
        answer.append(arr[c-1])
            

    return answer

array=[1, 5, 2, 6, 3, 7, 4]
commands=[[2, 5, 3], [4, 4, 1], [1, 7, 3]]
solution(array,commands)