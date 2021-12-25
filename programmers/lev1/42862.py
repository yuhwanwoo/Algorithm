def solution(n, lost, reserve):
    set_reserve=set(reserve)-set(lost)
    set_lost=set(lost)-set(reserve)
    
    while set_reserve:
        i=set_reserve.pop()
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    return n-len(set_lost)


n=2
lost=[1]
reserve=[2]