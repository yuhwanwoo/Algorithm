def solution(brown, yellow):
    answer = []
    sum_color=brown+yellow
    x=(brown+4+((brown+4)**2-16*(sum_color))**0.5)/4
    y=sum_color//x
    if x>y:
        answer=[x,y]
    else:
        answer=[y,x]
    return answer

brown=10
yellow=2
solution(brown, yellow)