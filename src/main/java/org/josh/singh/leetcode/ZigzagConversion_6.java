package org.josh.singh.leetcode;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 */
public class ZigzagConversion_6 {


    //     runtime 86ms   beats 5.77% .  45.19MB beats  9.35%
    public String convert(String s, int numRows) {
        char[][] zigzag = new char[numRows][1000];
        int column = 0;
        int row = 0;
        boolean vertical = true;
        for (char c : s.toCharArray()) {
            zigzag[row][column] = c;
            if (vertical) {

                if (row + 1 == numRows) {
                    vertical = false;
                    column++;
                    row = Math.max(0, row - 1);
                } else row++;
            } else {
                if (row == 0 && numRows != 1) {
                    row++;
                    vertical = true;
                } else {
                    row = Math.max(0, row - 1);
                    column++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zigzag.length; i++) {
            for (int j = 0; j < zigzag[i].length; j++) {
                if ((int) zigzag[i][j] != 0) {
                    sb.append(zigzag[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        new ZigzagConversion_6().convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                55);
    }

}


