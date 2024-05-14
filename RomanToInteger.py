class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        romanChar_to_int = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}
        i = len(s) - 1
        num = 0
        while (i >= 0):
            if (i < len(s) - 1 and romanChar_to_int[s[i]] < romanChar_to_int[s[i + 1]]):
                num -= romanChar_to_int[s[i]]
            else: 
                num += romanChar_to_int[s[i]]
            i -= 1
        return num