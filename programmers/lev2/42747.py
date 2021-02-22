def solution(citations):
    answer = 0
    citations.sort()
    length=len(citations)
    # 0 1 3 5 6
    for i in range(length):
        if citations[i]>=length-i:
            return length-i

    return 0

citations=[3,0,6,1,5]
citations=[1,2,4,5]
print(solution(citations))
#1,2,3,4,5
#1,2,4,5