# Given an integer x, return true if x is a palindrome, and false otherwise.
class Solution(object):
    def isPalindrome(self, x):
        x = str(x)
        i = 0
        j = len(x) - 1
        while (i < j):
            if (x[i] != x[j]):
                return False
            i += 1
            j -= 1
        return True
