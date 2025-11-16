def solution(a, b, c):
    answer = 0
    
    score1 = (a + b + c)
    score2 = score1 * (a**2 + b**2 + c**2)
    score3 = score2 * (a**3 + b**3 + c**3)
    
    if a != b and b != c and c != a:
        answer += score1
    elif a == b and b != c:
        answer += score2
    elif b == c and c != a:
        answer += score2
    elif c == a and a != b:
        answer += score2
    else:
        answer += score3
    
    return answer