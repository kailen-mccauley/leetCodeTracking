#Given a string s, find the length of the longest substring
# without repeating characters.
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        charSet = set()
        maxCount = 0
        count = 0
        head = 0

        for i, char in enumerate(s):
            while char in charSet:
                charSet.remove(s[head])
                head += 1
                count -= 1
            charSet.add(char)
            count += 1
            maxCount = max(maxCount, count)
        return maxCount
        