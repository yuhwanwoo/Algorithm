def solution(number, k):
    answer = ''
    last_index=k+1
    first_index=0
    while len(answer)!=(len(number)-k):
        temp_num=-1
        temp_index=-1
        for i in range(first_index,last_index):
            if number[i]=='9':
                temp_num=int(number[i])
                temp_index=i
                break
            if temp_num<int(number[i]):
                temp_num=int(number[i])
                temp_index=i
        answer+=str(temp_num)
        first_index=temp_index+1
        last_index=k+1+len(answer)
    return answer
