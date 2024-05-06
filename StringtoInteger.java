/**
 Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 The algorithm for myAtoi(string s) is as follows:

 Whitespace: Ignore any leading whitespace (" ").
 Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. 
 Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 
 Return the integer as the final result.
 */
class Solution {
    public int myAtoi(String s) {
        // Checks for null or empty input
        if (s == null || s.trim().equals("")) {
            return 0;
        }

        // Removes leading whitespaces
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        //Checks signage
        boolean isNegative;
        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            isNegative = false;
            i++;
        } else {
            isNegative = false;
        }

        //Removes leading zeros
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        } 

        // Parses string to int
        int result = 0;
        long resultHelper = 0;
        while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {

            // Can subtract off 0 character to get the actual digit value needed.
            int digit = s.charAt(i) - '0';
            resultHelper = resultHelper * 10 + digit;
            if (resultHelper < Integer.MIN_VALUE || resultHelper > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return isNegative ? -1 * result : result;
    }
}