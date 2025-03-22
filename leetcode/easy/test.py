def solution(S):
    if len(S) == 1:
        return -1
    count = 0
    last_tank_index = len(S)
    for index in range(len(S)):
        has_previous = False
        has_next = False

        if S[index] == "H":     # 1
            if index != 0 and S[index-1] == '-':
                has_previous = True
            if index != len(S) - 1 and S[index+1] == '-':
                has_next = True

            if not (has_previous or has_next):
                return -1
            # do we have - in prev or next
            if has_next and (index - 1 != last_tank_index or not has_previous):
                count += 1
                last_tank_index = index + 1
            if has_previous and not has_next and last_tank_index != index - 1:
                count += 1
                last_tank_index = index - 1
    return count

S = '-H-HH--'
S = 'H--H-H--H'
print(solution(S))