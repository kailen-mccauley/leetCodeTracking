#Given a string s, find the length of the longest substring
# without repeating characters.
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        # Utilize a set since we cannot have repeat elements
        charSet = set()
        maxCount = 0
        count = 0
        head = 0

        # Iterate across the entire string
        # If we hit a character that is in our set, we begin removing all elements before that repeate
        # We also remove the repeat element
        # Keep track of the max between maxCoutn and count 
        # There is a chance we never update maxCount, but count is higher than maxCount
        for i, char in enumerate(s):
            while char in charSet:
                charSet.remove(s[head])
                head += 1
                count -= 1
            charSet.add(char)
            count += 1
            maxCount = max(maxCount, count)
        return maxCount
        