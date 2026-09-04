def manualstrpresence(substr, string):
    i, str_ptr, substr_ptr = 0, 0, 0
    str_len = len(string)
    substr_len = len(substr)
    if substr_len <= 0:
        return True
    if str_len <= 0 or str_len < substr_len:
        return False
    while i <= (str_len - substr_len):
        str_ptr = i
        substr_ptr = 0
        while str_ptr < str_len and substr_ptr < substr_len and substr[substr_ptr] == string[str_ptr]:
            substr_ptr += 1
            str_ptr += 1
        if substr_ptr == substr_len:
            return True
        i += 1
    return False
string = input("Enter String: ")
substr = input("Enter SubString: ")
print(manualstrpresence(substr, string))
