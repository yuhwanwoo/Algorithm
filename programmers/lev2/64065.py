def solution(s):
    answer = []
    s=s[2:len(s)-2]
    s_list=s.split("},{")
    tuple_list=[]
    for i in s_list:
        tuple_list.append(list(map(int,i.split(","))))
    tuple_list.sort(key=lambda x:len(x))
    answer=tuple_list[0]
    for contents in tuple_list:
        for content in contents:
            if not content in answer:
                answer.append(content)
    print(answer)
    return answer

s="{{2},{2,1},{2,1,3},{2,1,3,4}}"
solution(s)