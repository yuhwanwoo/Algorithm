# 다른사람이 푼것
def solution(citations):
    citations.sort()
    l = len(citations)
    for i in range(l):
        if citations[i] >= l-i:
            # 논문이 인용된 횟수(h번 이상) >= 인용된 논문의 개수(h개 == h번)
            return l-i
    return 0

citations=[44,88,99,100,101,101]
print(solution(citations))