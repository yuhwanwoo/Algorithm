def solution(lottos, win_nums):
    answer = []
    lotto_dic = dict()

    win_cnt = 0

    cnt_0 = 0

    for lotto in lottos:
        if lotto in win_nums :
            win_cnt += 1
        if lotto == 0:
            cnt_0 += 1
    # print(win_cnt, cnt_0)

    if (win_cnt + cnt_0) < 2:
        answer.append(6)
    else:
        answer.append(7 - win_cnt - cnt_0)
    
    if 7 - win_cnt >= 6:
        answer.append(6)
    else:
        answer.append(7 - win_cnt)
    
    # print(answer)
    return answer

lottos = [44, 1, 0, 0, 31, 25]
win_nums = [31, 10, 45, 1, 6, 19]
# lottos = [1,2,3,4,5,6]
# win_nums = [7,8,9,10,11,12]
solution(lottos, win_nums)