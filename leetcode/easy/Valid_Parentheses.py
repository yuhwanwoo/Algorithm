def solution(s) :
    dic = {")":"(", "}":"{","]":"["}
    stk = []
    for i in s:
        if i not in dic.keys():
            stk.append(i)
        else:
            if not stk or stk.pop() != dic[i]:
                return False
    return len(stk) == 0

        
        


    

# s = "()"
# s = "()[]{}"
# s = "(]"
# s = "{[]}"
s = "]"
print(solution(s))