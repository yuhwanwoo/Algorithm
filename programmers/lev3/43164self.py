def solution(tickets):
    routes = dict()
    st = ["ICN"]
    answer = []

    for dep,arr in tickets:
        routes[dep]=routes.get(dep,[])+[arr]
        print(routes)


tickets=[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]

solution(tickets)