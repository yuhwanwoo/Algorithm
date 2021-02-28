import math

def solution(X,Y,D):
    answer=0
    Y-=X

    answer=math.ceil(Y/D)

    return answer


X=10
Y=85
D=30

# X=3
# Y=999111321
# D=7
print(solution(X,Y,D))