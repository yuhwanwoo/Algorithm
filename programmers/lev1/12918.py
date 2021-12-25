def solution(s):
    answer = True
    if len(s)==4 or len(s)==6:
        for i in s:
            if i.isalpha():
                answer=False
                break
    else:
        answer=False

s="a234"
solution(s)