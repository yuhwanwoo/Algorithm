n, m, k = map(int, input().split())

def comb(num, pick):
    if num == pick or pick == 0 :
        return 1
    else:
        add = 1
        for i in range(1, num+1):
            add *= i
        
        left = 1
        for i in range(1, pick + 1):
            left *= i
        
        right = 1
        for i in range(1, num - pick + 1):
            right *= i
        
        return add/(left*right)
        
    return 1

fail = 0

for i in range():
    
print(fail)