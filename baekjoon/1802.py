n=int(input())

def flag(fold):
    leng=len(fold)
    if leng==1:
        return True

    for i in range(leng//2):
        if fold[i]==fold[-i-1]:
            return False
    return flag(fold[:leng//2]) and flag(fold[leng//2+1:leng])

for i in range(n):
    fold=input()
    if flag(fold):
        print("YES")
    else:
        print("NO")