
/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
**/
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        String[] rows = new String[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = "";
        }
        int i = 0;
        while (i < s.length()) {
            int counter = 0;
            while (counter < numRows && i < s.length()) {
                rows[counter++] += s.charAt(i++);
            }
            counter = numRows - 2;
            while (counter > 0 && i < s.length()) {
                rows[counter--] += s.charAt(i++);
            }
        } 
        String output = "";
        for (String row : rows) {
            output += row;
        }
        return output;
    }
}