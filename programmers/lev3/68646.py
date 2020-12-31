def solution1(a):
    answer = 0
    if len(a)==3:
        return 3
    if len(a)<=2:
        return len(a)

    for i in range(len(a)):
        if i==0 or i==len(a)-1:
            answer+=1
        else:
            front_arr=a[:i]
            end_arr=a[i+1:]
            front_min=min(front_arr)
            end_min=min(end_arr)
            if(front_min<a[i] & end_min<a[i]):
                continue
            else:
                answer+=1
    return answer

def solution(a):
    answer=2
    if 0<=len(a)<=2:
        return len(a)
    left=a[0]
    right=a[-1]

    for i in range(1,len(a)-1):
        if left>a[i]:
            left=a[i]
            answer+=1
        if right>a[-1-i]:
            right=a[-1-i]
            answer+=1
    if left==right:
        return answer-1
    else:
        return answer

a=[9,-1,-5]
a=[-16,27,65,-2,58,-92,-71,-68,-61,-33]
solution(a)