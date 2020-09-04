import collections

def solution(participant, completion):
    answer=''
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]

participant=["leo", "kiki", "eden"]
completion=["eden","kiki"]

solution(participant, completion)