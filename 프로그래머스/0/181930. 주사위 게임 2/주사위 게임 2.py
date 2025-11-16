def solution(a, b, c):
    answer = 0
    
    score1 = (a + b + c)
    score2 = score1 * (a**2 + b**2 + c**2)
    score3 = score2 * (a**3 + b**3 + c**3)
    
    if a == b and b == c:
        answer += score3
    elif a == b or b == c or c == a:
        answer += score2
    else:
        answer += score1
    
    return answer