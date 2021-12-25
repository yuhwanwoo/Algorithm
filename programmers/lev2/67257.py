def cal(operation,n,expression):
    if n==2:   
        return str(eval(expression))
    oper=operation[n]
    temp=[]
    spl_list=expression.split(oper)
    for i in spl_list:
        temp.append(cal(operation,n+1,i))

    result=str(eval(oper.join(temp)))

    return result

def solution(expression):
    answer = 0
    operations=[("-","+","*"),("-","*","+"),("+","*","-"),("+","-","*"),("*","+","-"),("*","-","+")]
    
    for operation in operations:
        answer=max(answer,abs(int(cal(operation,0,expression))))
        
    return answer

expression="100-200*300-500+20"
solution(expression)