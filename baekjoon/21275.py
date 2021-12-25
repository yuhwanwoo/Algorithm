a,b=map(str,input().split())

num_dict=dict()

# 1부터 저장
for i in range(0,10):
    num_dict[str(i)]=i

# a부터 저장
for i in range(26):
    num_dict[chr(97+i)]=i+10


# 1:1 ~9:9
# a:10 b:11 c: 12 ~~ z:35

# 입력을 십진수로 변환
def trans(string, nary):
    answer=0
    length=len(string)
    for i in range(length):
        answer+=((int(nary)**i) * num_dict[string[-1-i]])
    return answer

cnt=0

# 입력중 하나가 a라면 11진수 이상부터 확인해야 하므로 11을 알아 내기 위해서
# 이 처리를 안하면 첫 테스트 케이스에 2개가 나와서 다른답을 출력한다.
a_max=0
b_max=0
for i in a:
    a_max=max(a_max,num_dict[i])

for i in b:
    b_max=max(b_max,num_dict[i])

answerA=0
answerB=0

for i in range(a_max+1,37):
    for j in range(b_max+1,37):
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