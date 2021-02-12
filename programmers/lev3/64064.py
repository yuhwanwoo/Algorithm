from itertools import permutations

def anal(content,banned_id,answer_set):
    for i in range(len(content)):
        if len(content[i])!=len(banned_id[i]):
            return False
        for j in range(len(content[i])):
            if banned_id[i][j]=="*" or banned_id[i][j]==content[i][j]:
                continue
            else:
                return False
    content=list(content)
    content.sort()
    content=tuple(content)
    answer_set.add(content)
    return True


def solution(user_id, banned_id):
    answer = 0
    com_list=list(permutations(user_id,len(banned_id)))
    answer_set=set()
    for content in com_list:
        if anal(content,banned_id,answer_set):
            answer+=1
    print(answer_set)
    answer=len(answer_set)
    
    return answer

user_id=["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id=["fr*d*", "abc1**"]
user_id=["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id=["*rodo", "*rodo", "******"]
solution(user_id, banned_id)