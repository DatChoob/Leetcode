package org.josh.singh.other;

import java.util.Arrays;

public class BinaryMinHeap {
    final int DEFAULT_ARRAY_SIZE = 10;
    private Integer[] items = new Integer[DEFAULT_ARRAY_SIZE];
    private int currentEmptyIndex = 0;

    public void insert(int item) {
        items[currentEmptyIndex] = item;
        bubbleUp(currentEmptyIndex);
        currentEmptyIndex++;
        if (currentEmptyIndex == items.length / 2) {
            resizeArray();
        }
    }

    public int remove() {
        int itemToReturn = items[0];
        items[0] = null;
        swap(items, 0, currentEmptyIndex - 1);
        currentEmptyIndex--;
        bubbleDown(0);
        return itemToReturn;
    }

    private void bubbleDown(int currentIndex) {
        Integer childLeft = null;
        Integer childRight = null;
        Integer currentItems = items[currentIndex];
        if (currentIndex * 2 + 1 <= currentEmptyIndex)
            childLeft = items[currentIndex * 2 + 1];
        if (currentIndex * 2 + 2 <= currentEmptyIndex)
            childRight = items[currentIndex * 2 + 2];

        if (childLeft != null || childRight != null) {
            if (childLeft == null) {
                if (currentItems > childRight) {
                    swap(items, currentIndex, currentIndex * 2 + 2);
                    bubbleDown(currentIndex * 2 + 2);
                }
            } else if (childRight == null) {
                if (currentItems > childLeft) {
                    swap(items, currentIndex, currentIndex * 2 + 1);
                    bubbleDown(currentIndex * 2 + 1);
                }
            } else {
                if (childLeft > childRight) {
                    if (currentItems > childRight) {
                        swap(items, currentIndex, currentIndex * 2 + 2);
                        bubbleDown(currentIndex * 2 + 2);
                    }
                } else {
                    if (currentItems > childLeft) {
                        swap(items, currentIndex, currentIndex * 2 + 1);
                        bubbleDown(currentIndex * 2 + 1);
                    }
                }

            }
        }


    }

    private void resizeArray() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public int peek() {
        return items[0];
    }

    public int size() {
        return currentEmptyIndex;
    }

    public boolean isEmpty() {
        return currentEmptyIndex == 0;
    }

    public void bubbleUp(int curIndex) {
        if (curIndex == 0) return;
        int currentItem = items[curIndex];
        int parentItem = items[(curIndex - 1) / 2];
        if (currentItem < parentItem) {
            swap(items, curIndex, (curIndex - 1) / 2);
            bubbleUp((curIndex - 1) / 2);
        }
    }

    private void swap(Integer[] items, int curIndex, int parentIndex) {
        Integer temp = items[curIndex];
        items[curIndex] = items[parentIndex];
        items[parentIndex] = temp;
    }
}
