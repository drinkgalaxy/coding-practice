def solution(num_list):

    e = ""
    o = ""
    
    for n in num_list:
        if n % 2 == 0:
            e += str(n)
        else:
            o += str(n)
    
    return int(e) + int(o)