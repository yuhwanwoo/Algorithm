def solution(n):
    answer = 0
    number_distinction=n+1
    binary_num_init=""
    cnt=0
    cnt1=0
    while n>=1:
        # 사실상 이건 필요없음
        binary_num_init=str(n%2)+binary_num_init
        
        if n%2==1:
            cnt+=1
        n//=2
    print(cnt)
    while True:
        num=number_distinction
        while num>=1:
            if num%2==1:
                cnt1+=1
            num//=2

        if cnt==cnt1:
            break
        cnt1=0
        number_distinction+=1

    answer=number_distinction
    print(answer)
    return answer

n=78
solution(n)