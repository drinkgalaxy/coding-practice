def solution(code):
    mode = 0
    ret = ''
    for i in range(len(code)):
        if mode == 0: #mode가 0일 때
            if code[i] == "1":
                mode = 1
            else:
                if i % 2 == 0:
                    ret += code[i]
                    i += 1
        else: #mode가 1일 때
            if code[i] == "1":
                mode = 0
            else:
                if i % 2 == 1:
                    ret += code[i]
                    i += 1
            
    if ret == "":
        return "EMPTY"
    else:
        return ret
