a,b=map(str,input().split())

num_dict=dict()
for i in range(0,10):
    num_dict[str(i)]=i


for i in range(26):
    num_dict[chr(97+i)]=i+10


def trans(string, nary):
    answer=0
    length=len(string)
    for i in range(length):
        answer+=((int(nary)**i) * num_dict[string[-1-i]])
    return answer
cnt=0

a_max=0
b_max=0
for i in a:
    a_max=max(a_max,num_dict[i])

for i in b:
    b_max=max(b_max,num_dict[i])

answerA=0
answerB=0

for i in range(a_max+1,36):
    for j in range(b_max+1,36):
        if i==j:
            continue
        if trans(a,i)==trans(b,j):
            if trans(a,i)>=2**63:
                continue
            answerA=i
            answerB=j
            cnt+=1

if cnt==0:
    print("Impossible")
elif cnt>1:
    print("Multiple")
elif cnt==1:
    print(trans(a,answerA),answerA,answerB)