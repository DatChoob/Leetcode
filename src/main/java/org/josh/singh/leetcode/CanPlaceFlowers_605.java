package org.josh.singh.leetcode;

//You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
//
//Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
public class CanPlaceFlowers_605 {

    //    1ms
//    Beats 98.59%of users with Java
//    43.65mb
//    Beats 93.53%of users with Java
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//handle edge case of n==1 and only 1 flowerbed that is also open.
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) return true;

            if (flowerbed[i] == 0) {
                boolean prevIsOpen = i - 1 >= 0 && flowerbed[i - 1] == 0;
                boolean nextIsOpen = i + 1 < flowerbed.length && flowerbed[i + 1] == 0;
                if (i == 0 && nextIsOpen) {
                    flowerbed[i] = 2;
                    n--;
                } else if (i == flowerbed.length - 1 && prevIsOpen) {
                    flowerbed[i] = 2;
                    n--;
                } else if (prevIsOpen && nextIsOpen) {
                    flowerbed[i] = 2;
                    n--;
                }
            }
        }
        return n == 0;

    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers_605().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
    }

}
