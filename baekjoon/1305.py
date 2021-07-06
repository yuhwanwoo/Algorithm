def getPi(p):
    m=len(p)
    j=0
    pi=[0]*m
    for i in range(1,m):
        while(j > 0 and p[i] != p[j]):
            j = pi[j-1]
        if p[i] == p[j]:
            j+=1
            pi[i] = j
    return pi

n=int(input())
m=input()
print(n-getPi(m)[n-1])