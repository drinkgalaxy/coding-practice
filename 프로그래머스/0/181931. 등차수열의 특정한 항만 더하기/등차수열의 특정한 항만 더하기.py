def solution(a, d, included):
    plus = a
    answer = 0
    for i in range(len(included)):
        if included[i]:
            answer += plus
        plus += d
    return answer