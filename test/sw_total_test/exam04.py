def get_divisor(n):
    n = int(n)
    div = []
    divback = [] 

    for i in range(1, int(n**(1/2)) + 1): 
        if (n % i == 0):            
            div.append(i)
            if (i != (n // i)): 
                divback.append(n//i)
    answer=div + divback[::-1]
    return answer[1]

n=13
print(get_divisor(n))