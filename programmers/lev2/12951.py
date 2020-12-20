def solution(s):
    answer = ''
    s_list=s.split()
    answer=s[0].upper()
    for i in range(1,len(s)):
        if s[i-1]==" ":
            answer+=s[i].upper()
        else:
            answer+=s[i].lower()
    
    print(answer)
    return answer


s="3people  unFollowed me"
solution(s)