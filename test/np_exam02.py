def solution(A, X):
    N = len(A)
    if N == 0:
        return -1
    l = 0
    r = N - 1
    while l < r:
        m = (l + r) // 2
        if A[m] > X:
            r = m - 1
        else:
            l = m+1
        if A[m] == X:
            return m
    return -1

A=[1,2,5,9,9]
A=[1,2,6,6,9,9]
A=[1,2,5,5,5,5]
X=5
print(solution(A,X))