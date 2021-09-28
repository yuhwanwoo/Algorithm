def solution(enter, leave):
    answer = [0] * len(enter)

    room = []
    e_idx = 0
    for l in leave:
        while l not in room:
            room.append(enter[e_idx])
            e_idx += 1
        room.remove(l)
        for p in room:
            answer[p - 1] += 1
        answer[l - 1] += len(room)
        print(room)

    return answer

enter = [1,3,2]
leave = [1,2,3]
# enter = [1,4,2,3]
# leave = [2,1,3,4]
solution(enter, leave)