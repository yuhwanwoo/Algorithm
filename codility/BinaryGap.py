def solution(N):

    b=bin(N)
    b=b[2:]
    answer_length=[]
    length=0
    print(b)
    for i in range(len(b)):
        if b[i]=="1":
            answer_length.append(i)

    if len(answer_length)==1:
        return 0
    else:
        for i in range(1,len(answer_length)):
            length=max(length,answer_length[i]-answer_length[i-1])
    return length-1
    



N=33
print(solution(N))