import sys

N = int(sys.stdin.readline())

start_idx = 1
end_idx = 1
count = 1
sum_val = 1  
while end_idx != N:
    if sum_val < N: 
        end_idx += 1
        sum_val += end_idx
    elif sum_val > N: 
        sum_val -= start_idx
        start_idx += 1
    else:
        count += 1
        end_idx += 1
        sum_val += end_idx
        
print(count)
