class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        triples = []
        nums.sort()
        for i in range(len(nums) - 2):
            # We need to just up until we don't have a duplicate. 
            if (i > 0 and nums[i] == nums[i-1]):
                continue
            left = i + 1
            right = len(nums) - 1
            while (left < right):
                tripleSum = nums[i] + nums[left] + nums[right]
                if (tripleSum == 0):
                    triples.append([nums[i], nums[left], nums[right]])
                    # There could still be outer triplets with our fixed nums[i] so we still need to
                    # conitnue until left and right cross
                    while(left < right and nums[left] == nums[left + 1]):
                        left += 1
                    while (left < right and nums[right] == nums[right - 1]):
                        right -= 1
                    left += 1
                    right -= 1
                elif (tripleSum < 0):
                    left += 1
                else:
                    right -= 1
        return triples