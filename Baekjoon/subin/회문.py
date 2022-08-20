t = int(input())

def ispseudo(word, left, right):
    while left < right:
        if word[left] == word[right]:
            left += 1
            right -= 1
        else:
            return False
    return True

def ispalindrome(word, left, right):
    if word == word[::-1]:
        return 0
    else:
        while left < right:
            if word[left] != word[right]:
                check_left = ispseudo(word, left, right-1)
                check_right = ispseudo(word, left+1, right)

                if check_left or check_right:
                    return 1
                else:
                    return 2
            else:
                left += 1
                right -= 1

for _ in range(t):
    word = input()
    left, right = 0, len(word) - 1
    result = ispalindrome(word, left, right)

    print(result)