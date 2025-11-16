def solution(num_list):
    answer = 0
    
    multi = 1
    square = 0
    for i in num_list:
        multi *= i
        square += i
        
    if multi < square**2:
        return 1
    elif multi > square**2:
        return 0       