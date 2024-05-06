/**
 Given a signed 32-bit integer x, return x with its digits reversed. 
 If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * **/
class Solution {
    public int reverse(int x) {
        int result = 0; 
        long resultHelper = 0;
        while (x != 0) {
            int temp = x % 10;
            resultHelper = resultHelper * 10 + temp;
            if (resultHelper < Integer.MIN_VALUE || resultHelper > Integer.MAX_VALUE) {
                return 0;
            }
            result = result * 10 + temp;
            x /= 10;
        }
        return result;
    }
}