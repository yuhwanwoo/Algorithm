from collections import deque
import sys

input = sys.stdin.readline
N, M = map(int,input().split())
recipe_dict = {}
next_node_list = [set() for _ in range(N+1)]
for _ in range(M):
    input_list = list(map(int,input().split()))
    recipe = input_list[1:-1]
    liquid_number = input_list[-1]
    recipe.sort()
    if recipe_dict.get(liquid_number):
        recipe_dict[liquid_number].append([set(recipe),input_list[0]])
    else:
        recipe_dict[liquid_number] = [[set(recipe),input_list[0]]]

    for num in recipe:
        next_node_list[num].add(liquid_number)

L = int(input())
own_liquid = list(map(int,input().split()))
possible_list = [False]*(N+1)
result = set()
for num in own_liquid:
    possible_list[num] = True
    result.add(num)
queue = deque(own_liquid)
while queue:
    cur_num = queue.popleft()

    next_nodes = next_node_list[cur_num]

    for next_node in next_nodes:
        if possible_list[next_node]:
            continue
        for ind in range(len(recipe_dict[next_node])):
            recipe = recipe_dict[next_node][ind][0]
            cnt = recipe_dict[next_node][ind][1]

            if cur_num in recipe:
                cnt -= 1
                recipe.remove(cur_num)
                recipe_dict[next_node][ind][0] = recipe
                recipe_dict[next_node][ind][1] = cnt
                if cnt == 0:
                    possible_list[next_node] = True
                    queue.append(next_node)
                    result.add(next_node)


print(len(result))
result = sorted(list(result))
print(result)