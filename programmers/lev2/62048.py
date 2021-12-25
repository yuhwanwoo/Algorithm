# 멀쩡한 사각형
# 문제가 어렵진 않은데 직접 그려서 도출해야할듯
import math

def solution(w,h):
    
    return w*h-(w+h-math.gcd(w,h))

w=3
h=4
solution(w,h)

# 1 1 1
# 1 2 2
# 2 2 2
# 1 3 3
# 2 3 4
# 3 3 3
# 4 3 6
# 5 5 5
# 3 4 6