class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        strs = sorted(strs)
        shortestWord = strs[0]
        longestWord = strs[len(strs) - 1]
        prefix = ""
        for i in range(len(shortestWord)):
            if (shortestWord[i] != longestWord[i]):
                return prefix
            else:
                prefix += shortestWord[i]
        return prefix