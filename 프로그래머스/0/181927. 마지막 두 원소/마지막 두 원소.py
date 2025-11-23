def solution(num_list):
    
    if num_list[-1] > num_list[-2]:
        n = num_list[-1] - num_list[-2]
        num_list.append(n)
    else:
        n = num_list[-1] * 2
        num_list.append(n)
    
    return num_list