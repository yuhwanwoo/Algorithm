def calc(priority, n, expression):
    if n == 2:
        return str(eval(expression))
    if priority[n] == '*':
        print('*'.join([calc(priority, n+1, e) for e in expression.split('*')]))
        res = eval('*'.join([calc(priority, n+1, e) for e in expression.split('*')]))
        print("res1",res)
    if priority[n] == '+':
        print('+'.join([calc(priority, n+1, e) for e in expression.split('+')]))
        res = eval('+'.join([calc(priority, n+1, e) for e in expression.split('+')]))
        print("res2",res)
    if priority[n] == '-':
        print('-'.join([calc(priority, n+1, e) for e in expression.split('-')]))
        res = eval('-'.join([calc(priority, n+1, e) for e in expression.split('-')]))
        print("res3",res)
    return str(res)

def solution(expression):
    answer = 0
    priorities = [
        ('*', '-', '+'),
        ('*', '+', '-'),
        ('+', '*', '-'),
        ('+', '-', '*'),
        ('-', '*', '+'),
        ('-', '+', '*')
    ]
    for priority in priorities:
        print(priority)
        res = int(calc(priority, 0, expression))
        print(res)
        break
        answer = max(answer, abs(res))
    
    return answer

expression="100-200*300-500+20"
solution(expression)