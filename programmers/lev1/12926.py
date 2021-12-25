def solution(s, n):
    answer = ''
    
    for i in s:
        if i.isupper():
            i=chr((ord(i)-ord('A')+ n)%26+ord('A'))
        elif i.islower(): 
            i=chr((ord(i)-ord('a')+ n)%26+ord('a'))
        answer+=i
    return answer

s="AB"
n=1
solution(s,n)