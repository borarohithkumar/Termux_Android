def countSubs(q, answered, needed):
    for i in range(len(needed)):
        if needed[i] > answered[i]:
            answered[i] = needed[i] - answered[i]
        else:
            answered[i] = 0
    answered.sort()
    count = 0
    for deficit in answered:
        if q >= deficit:
            q -= deficit
            count += 1
        else:
            break    
    return count

answered = [2, 4, 1]
needed = [4, 5, 4]
q = 4
print(countSubs(q, answered, needed))
