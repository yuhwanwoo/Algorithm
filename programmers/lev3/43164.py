# 여행경로
def solution(tickets):
    routes = dict()
    st = ["ICN"]
    answer = []

    for (start, end) in tickets:
        print(start, end)
        routes[start] = routes.get(start, []) + [end]
        print(routes[start])

    for r in routes.keys():
        routes[r].sort(reverse=True)

    while st:
        top = st[-1]

        if top not in routes or len(routes[top])==0:
            answer.append(st.pop())
        else:
            st.append(routes[top][-1])
            routes[top] = routes[top][:-1]

    return answer[::-1]

tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]

solution(tickets)