def solution(n, t, m, p):
    answer = ''
    
    string=''

    alpha=dict()

    for i in range(10):
        alpha[i]=str(i)
    alpha[10]="A"
    alpha[11]="B"
    alpha[12]="C"
    alpha[13]="D"
    alpha[14]="E"
    alpha[15]="F"

    for i in range(t*m):
        temp=""
        if i==0:
            string="0"
            continue
        while i>0:
            temp=alpha[i%n]+temp
            i=i//n
        string+=temp
    
    for i in range(p-1,t*m,m):
        answer+=string[i]

    return answer

n=2
t=4
m=2
p=1
solution(n,t,m,p)