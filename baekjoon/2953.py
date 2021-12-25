
score=[]

for i in range(5):
    a,b,c,d=map(int,input().split())
    score.append((a+b+c+d,i))

score.sort()

print(score[-1][1]+1,score[-1][0])